import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionMetadata } from '../../entities/QuestionMetadata';
import { QueryService } from '../../services/query.service';
import { NgFor, NgIf } from '@angular/common';
import { TagBadgesComponent } from '../common-elements/tags-box/tag-badges/tag-badges.component';

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

  constructor(public qService: QueryService, private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe((value) => {
      this.id = value["id"];
      if (this.id) {
        this.qService.getQuestionMetadata(this.id).then((value2) => {
          this.question = value2;
        });
        this.qService.getQuestionBody(this.id).then((value2) => {
          this.questionBody = value2;
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
