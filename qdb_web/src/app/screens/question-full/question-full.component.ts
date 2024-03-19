import { Component, SecurityContext } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionMetadata } from '../../entities/QuestionMetadata';
import { QueryService } from '../../services/query.service';
import { NgFor, NgIf } from '@angular/common';
import { TagBadgesComponent } from '../common-elements/tags-box/tag-badges/tag-badges.component';
import { DomSanitizer } from '@angular/platform-browser';
import * as marked from 'marked';
import { Constants } from '../../../constants';

@Component({
  selector: 'app-question-full',
  standalone: true,
  imports: [NgIf, NgFor, TagBadgesComponent],
  templateUrl: './question-full.component.html',
  styleUrl: './question-full.component.css'
})
export class QuestionFullComponent {
  private id!: number;
  public question: QuestionMetadata | undefined;
  public questionBody: string | undefined;
  public questionBodyFormatted: string | null | undefined;

  constructor(public qService: QueryService, private route: ActivatedRoute, private router: Router, private sanitizer: DomSanitizer) {
    this.route.params.subscribe((value) => {
      this.id = value["id"];
      if (this.id) {
        this.qService.getQuestionMetadata(this.id).then((value2) => {
          this.question = value2;
          this.qService.getQuestionBody(this.id).then((value3) => {
            this.questionBody = value3;
            for (let i of this.question!.imagesUrls) {
              let imagename = i.substring(i.lastIndexOf("/") + 1);
              this.questionBody = this.questionBody.replace(imagename, `${Constants.WEBPAGE_URL}java/api/image/${imagename}`);
            }
            this.questionBodyFormatted = this.sanitizer.sanitize(SecurityContext.HTML, marked.parse(this.questionBody));
          });
        });
      } else {
        this.router.navigate(["404"]);
      }
    });
  }

  public backButtonHandler(e: Event) {
    e.preventDefault();
    history.back();
  }
}
