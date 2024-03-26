import { AfterViewInit, Component, SecurityContext } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionMetadata } from '../../entities/QuestionMetadata';
import { QueryService } from '../../services/query.service';
import { NgFor, NgIf } from '@angular/common';
import { TagBadgesComponent } from '../common-elements/tags-box/tag-badges/tag-badges.component';
import { DomSanitizer } from '@angular/platform-browser';
import * as marked from 'marked';
import { Constants } from '../../../constants';
import { FormsModule } from '@angular/forms';
import { AlertService } from '../../services/alert.service';
import { QuestionUpdate } from '../../entities/QuestionModify';
import { ImageListCardComponent } from './image-list-card/image-list-card.component';

@Component({
  selector: 'app-question-full',
  standalone: true,
  imports: [NgIf, NgFor, TagBadgesComponent, FormsModule, ImageListCardComponent],
  templateUrl: './question-full.component.html',
  styleUrl: './question-full.component.css'
})
export class QuestionFullComponent implements AfterViewInit {
  private id!: number;
  public question: QuestionMetadata | undefined;
  private _questionBody: string | undefined;
  public set questionBody(val: string) {
    this._questionBody = val;
    this.questionBodyFormatted = this.sanitizer.sanitize(SecurityContext.HTML, marked.parse(val));
    for (let i of this.question!.imagesUrls) {
      this.questionBodyFormatted = this.questionBodyFormatted?.replaceAll(i, `${Constants.WEBPAGE_URL}java/api/image/${i}`);
    }
    for (let i of this.newImages) {
      this.questionBodyFormatted = this.questionBodyFormatted?.replaceAll(i, `${Constants.WEBPAGE_URL}java/api/image/${i}`);
    }
  }
  public get questionBody(): string | undefined {
    return this._questionBody;
  }
  public questionBodyFormatted: string | null | undefined;
  public isInEditMode: boolean = false;
  public tagsRaw: string = "";
  public newImages: string[] = [];
  private imagesToDelete: string[] = [];

  constructor(public qService: QueryService, private aService: AlertService, private route: ActivatedRoute, private router: Router, private sanitizer: DomSanitizer) {
    this.route.params.subscribe((value) => {
      this.id = value["id"];
      if (this.id) {
        this.getQuestionData();
      } else {
        this.router.navigate(["404"]);
      }
    });
  }

  ngAfterViewInit(): void {
    let button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    button.addEventListener("change", () => {
      let formdata = new FormData();
      formdata.append("file", button.files?.item(0) as File);
      let xhr = new XMLHttpRequest();
      xhr.open("POST", this.qService.getImagePostUrl());
      xhr.withCredentials = true;
      xhr.addEventListener("loadend", () => {
        if (xhr.status == 201) {
          this.newImages.push(xhr.response);
        } else if (xhr.responseText == "" || xhr.status == 413) {
          this.aService.pushAlert("ERROR", "Please upload an image smaller than 5MB");
        } else {
          this.aService.pushAlert("ERROR", xhr.responseText);
        }
        button.value = "";
      });
      xhr.send(formdata);
    });
  }

  private getQuestionData() {
    this.qService.getQuestionMetadata(this.id).then((value2) => {
      this.question = value2;
      this.qService.getQuestionBody(this.id).then((value3) => {
        this.questionBody = value3;
      });
      this.tagsRaw = this.question.tags.join(",");
    });
  }

  public backButtonHandler(e: Event) {
    e.preventDefault();
    history.back();
  }

  public editButtonHandler() {
    this.isInEditMode = true;
  }

  public abortButtonHandler() {
    this.isInEditMode = false;
    this.newImages = [];
    this.imagesToDelete = [];
    this.getQuestionData();
  }

  public async saveButtonHandler() {
    let tags = this.tagsRaw.split(",");
    let allOk = true;
    let response = await this.qService.updateExistingQuestion(this.question?.id!, {
      title: this.question?.title,
      mdbody: this.questionBody,
      tags: tags
    } as QuestionUpdate);
    if (response.status != 200) {
      this.aService.pushAlert("ERROR", await response.text());
      allOk = false;
    }
    for (let i = 0; i < this.newImages.length; i++) {
      let res = await this.qService.bindImage(this.newImages[i], this.question?.id!);
      if (res.status != 200) {
        this.aService.pushAlert("ERROR", await res.text());
        allOk = false;
      } else {
        this.newImages.splice(i, 1);
        i--;
      }
    }
    for (let i = 0; i < this.imagesToDelete.length; i++) {
      let res = await this.qService.deleteImage(this.imagesToDelete[i]);
      if (res.status != 200) {
        this.aService.pushAlert("ERROR", await res.text());
        allOk = false;
      } else {
        this.imagesToDelete.splice(i, 1);
        i--;
      }
    }
    if (allOk) {
      this.isInEditMode = false;
      this.getQuestionData();
      this.aService.pushAlert("SUCCESS", "Question successfully updated");
      this.imagesToDelete = [];
      this.newImages = [];
    }
  }

  public uploadImageHandler() {
    let button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    button.click();
  }

  public deleteButtonHandler() {
    (document.getElementById("delete-question-modal-opener") as HTMLButtonElement).click();
  }

  public async sendDeleteRequest() {
    let response = await this.qService.deleteQuestion(this.question?.id!);
    if (response.status == 200) {
      history.back();
      this.aService.pushAlert("SUCCESS", "Question successfully deleted");
    } else {
      this.aService.pushAlert("ERROR", await response.text());
    }
  }

  public imageCardClickHandler(name: string) {
    this.questionBody += `\n\n![](${name})`;
  }

  public deleteImageHandler(name: string) {
    if (this.newImages.splice(this.newImages.indexOf(name), 1).length == 0) {
      this.question?.imagesUrls.splice(this.question?.imagesUrls.indexOf(name), 1);
    }
    this.imagesToDelete.push(name);
  }
}
