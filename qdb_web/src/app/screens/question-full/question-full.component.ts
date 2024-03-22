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

@Component({
  selector: 'app-question-full',
  standalone: true,
  imports: [NgIf, NgFor, TagBadgesComponent, FormsModule],
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
  }
  public get questionBody(): string | undefined {
    return this._questionBody;
  }
  public questionBodyFormatted: string | null | undefined;
  public isInEditMode: boolean = false;
  public tagsRaw: string = "";

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
      xhr.open("POST", this.qService.getCurrentProfilePictureUrl());
      xhr.withCredentials = true;
      xhr.addEventListener("loadend", () => {
        if (xhr.status == 200) {
          location.reload();
        } else {
          this.aService.pushAlert("ERROR", xhr.responseText == "" ? "Please upload an image smaller than 5MB" : xhr.responseText);
        }
      });
      //xhr.send(formdata);
      console.log("sent");
    });
  }

  private getQuestionData() {
    this.qService.getQuestionMetadata(this.id).then((value2) => {
      this.question = value2;
      this.qService.getQuestionBody(this.id).then((value3) => {
        this.questionBody = value3;
        for (let i of this.question!.imagesUrls) {
          let imagename = i.substring(i.lastIndexOf("/") + 1);
          this.questionBody = this.questionBody.replace(imagename, `${Constants.WEBPAGE_URL}java/api/image/${imagename}`);
        }
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
    this.getQuestionData();
  }

  public saveButtonHandler() {
    let tags = this.tagsRaw.split(",");
    console.log(tags);
  }

  public uploadImageHandler() {
    let button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    button.click();
  }
}
