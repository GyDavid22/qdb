import { NgFor, NgIf } from '@angular/common';
import { AfterViewInit, Component, OnDestroy, SecurityContext } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import * as marked from 'marked';
import { Constants } from '../../../constants';
import { QuestionMetadata } from '../../entities/QuestionMetadata';
import { QuestionUpdate } from '../../entities/QuestionModify';
import { TagResponse } from '../../entities/TagResponse';
import { AlertService } from '../../services/alert.service';
import { QueryService } from '../../services/query.service';
import { TagBadgesComponent } from '../common-elements/tags-box/tag-badges/tag-badges.component';
import { ImageListCardComponent } from './image-list-card/image-list-card.component';

@Component({
  selector: 'app-question-full',
  standalone: true,
  imports: [NgIf, NgFor, TagBadgesComponent, FormsModule, ImageListCardComponent],
  templateUrl: './question-full.component.html',
  styleUrl: './question-full.component.css'
})
export class QuestionFullComponent implements AfterViewInit, OnDestroy {
  private id!: number;
  public question: QuestionMetadata | undefined;
  private _questionBody: string = "";
  public set questionBody(val: string) {
    this._questionBody = val;
    this.questionBodyFormatted = this.sanitizer.sanitize(SecurityContext.HTML, marked.parse(val));
    this.questionBodyFormatted = this.questionBodyFormatted?.replaceAll("<blockquote>", '<blockquote class="ms-4">');
    for (let i of this.question!.imagesUrls) {
      this.questionBodyFormatted = this.questionBodyFormatted?.replaceAll(i, `${Constants.WEBPAGE_URL}java/api/image/${i}`);
    }
    for (let i of this.newImages) {
      this.questionBodyFormatted = this.questionBodyFormatted?.replaceAll(i, `${Constants.WEBPAGE_URL}java/api/image/${i}`);
    }
  }
  public get questionBody(): string {
    return this._questionBody;
  }
  public questionBodyFormatted: string | null | undefined;
  public isInEditMode: boolean = false;
  public tagsRaw: string = "";
  public newImages: string[] = [];
  private imagesToDelete: string[] = [];
  public isInCreateMode: boolean = false;
  private wasInCreateMode: boolean = false;
  public recommendedTagsShown: boolean;
  public recommendedTags: TagResponse[] = [];
  public waitingForPdf: boolean;
  private eventHandler: (e: KeyboardEvent) => any;

  constructor(public qService: QueryService, private aService: AlertService, private route: ActivatedRoute, private router: Router, private sanitizer: DomSanitizer) {
    this.recommendedTagsShown = false;
    this.waitingForPdf = false;
    this.route.params.subscribe((value) => {
      let page = value["id"];
      if (page) {
        if (page !== "new") {
          this.id = page as number;
          this.isInCreateMode = false;
          this.wasInCreateMode = false;
          this.isInEditMode = false;
          this.getQuestionData();
        } else {
          this.isInCreateMode = true;
          this.wasInCreateMode = true;
          this.isInEditMode = true;
          this.question = {
            id: -1,
            title: "",
            tags: [],
            imagesUrls: [],
            createdby: "",
            isReported: false,
            currentUserHasEditingRights: false,
            inFavorites: false
          };
          this.questionBody = "";
          this.tagsRaw = "";
          this.newImages = [];
          this.imagesToDelete = [];
        }
      } else {
        this.router.navigate(["404"]);
      }
    });
    this.eventHandler = (e: KeyboardEvent) => {
      e = e || window.event;
      if (e.keyCode === 37) {
        this.goBack();
      } else if (e.keyCode === 39) {
        this.goForward();
      }
    };
    try {
      document.addEventListener("keydown", this.eventHandler);
    } catch { }
  }

  ngOnDestroy(): void {
    try {
      document.removeEventListener("keydown", this.eventHandler);
    } catch { }
  }

  ngAfterViewInit(): void {
    let button: HTMLInputElement;
    try {
      button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    } catch (ReferenceError) { return; } // there shouldn't be an error here, it just throws a message in ng serve
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

  private async getQuestionData() {
    let response = await this.qService.getQuestionMetadata(this.id);
    this.question = await response.json() as QuestionMetadata;
    this.qService.getQuestionBody(this.id).then((value) => {
      this.questionBody = value;
    });
    this.tagsRaw = this.question.tags.join(",");
  }

  public backButtonHandler(e: Event) {
    e.preventDefault();
    let val: string | null = null;
    try {
      val = sessionStorage.getItem("lastvisit");
    } catch { }
    if (val !== null) {
      this.router.navigateByUrl(val);
    } else {
      if (!this.wasInCreateMode) {
        history.back();
      } else {
        this.router.navigate([""]);
      }
    }
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
    if (this.isInCreateMode) {
      let response = await this.qService.addQuestion({
        title: this.question?.title,
        mdbody: this.questionBody,
        tags: tags
      } as QuestionUpdate);
      let responseText = await response.text();
      if (response.status != 201) {
        this.aService.pushAlert("ERROR", responseText);
        return;
      }
      this.id = parseInt(responseText);
      this.question!.id = this.id;
    } else {
      let response = await this.qService.updateExistingQuestion(this.question?.id!, {
        title: this.question?.title,
        mdbody: this.questionBody,
        tags: tags
      } as QuestionUpdate);
      let responseText = await response.text();
      if (response.status != 200) {
        this.aService.pushAlert("ERROR", responseText);
        allOk = false;
      }
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
      this.imagesToDelete = [];
      this.newImages = [];
      if (this.isInCreateMode) {
        this.isInCreateMode = false;
        this.aService.pushAlert("SUCCESS", "Question successfully created");
        this.router.navigate([`/question/${this.id}`]);
      } else {
        this.aService.pushAlert("SUCCESS", "Question successfully updated");
        this.getQuestionData();
      }
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
    this.questionBody += `\n\n<img src="${name}" width=100%>`;
  }

  public deleteImageHandler(name: string) {
    if (this.newImages.splice(this.newImages.indexOf(name), 1).length == 0) {
      this.question?.imagesUrls.splice(this.question?.imagesUrls.indexOf(name), 1);
    }
    this.imagesToDelete.push(name);
  }

  public async showRecommendedTags() {
    if (!this.recommendedTagsShown) {
      this.recommendedTagsShown = true;
      let tags = await this.qService.tagsWithCounts();
      let splitted = this.tagsRaw.split(",");
      for (let i of tags) {
        if (this.questionBody?.toLowerCase().indexOf(i.name) != -1 && splitted.indexOf(i.name) == -1) {
          this.recommendedTags.push(i);
        }
      }
      this.recommendedTags.sort((a, b) => b.count - a.count);
    }
  }

  public hideRecommendedTags() {
    this.recommendedTagsShown = false;
    this.recommendedTags = [];
  }

  public appendTag(tag: string) {
    if (this.tagsRaw == "") {
      this.tagsRaw += tag;
    } else {
      this.tagsRaw += `,${tag}`;
    }
  }

  public async reportButton() {
    let res = await this.qService.reportQuestion(this.id);
    if (res.status == 200) {
      this.aService.pushAlert("SUCCESS", "Successfully reported this question");
      this.getQuestionData();
    } else {
      this.aService.pushAlert("ERROR", await res.text());
    }
  }

  public async unReportButton() {
    let res = await this.qService.unReportQuestion(this.id);
    if (res.status == 200) {
      this.aService.pushAlert("SUCCESS", "Successfully unreported this question");
      this.getQuestionData();
    } else {
      this.aService.pushAlert("ERROR", await res.text());
    }
  }

  public async addToFavorites() {
    let res = await this.qService.addToFavorites(this.id);
    if (res.status == 200) {
      this.aService.pushAlert("SUCCESS", "Successfully added to favorites");
      this.getQuestionData();
    } else {
      this.aService.pushAlert("ERROR", await res.text());
    }
  }

  public async removeFromFavorites() {
    let res = await this.qService.removeFromFavorites(this.id);
    if (res.status == 200) {
      this.aService.pushAlert("SUCCESS", "Successfully removed from favorites");
      this.getQuestionData();
    } else {
      this.aService.pushAlert("ERROR", await res.text());
    }
  }

  public async downloadPdfButton() {
    if (!this.waitingForPdf) {
      this.waitingForPdf = true;
      window.location.href = this.qService.getDownloadPdfUrl([this.id]);
      this.waitingForPdf = false;
    }
  }

  public async goBack() {
    let number = await this.qService.getLeftNeighbor(this.id);
    if (number === undefined) {
      this.aService.pushAlert("INFO", "There are no more questions in this direction");
    } else {
      this.router.navigate([`question/${number}`]);
    }
  }

  public async goForward() {
    let number = await this.qService.getRightNeighbor(this.id);
    if (number === undefined) {
      this.aService.pushAlert("INFO", "There are no more questions in this direction");
    } else {
      this.router.navigate([`question/${number}`]);
    }
  }
}
