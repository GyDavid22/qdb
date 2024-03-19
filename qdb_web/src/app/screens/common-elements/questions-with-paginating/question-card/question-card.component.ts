import { Component, Input } from '@angular/core';
import { QuestionMetadata } from '../../../../entities/QuestionMetadata';
import { NgFor, NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';
import { QueryService } from '../../../../services/query.service';
import { TagBadgesComponent } from '../../tags-box/tag-badges/tag-badges.component';

@Component({
  selector: 'app-question-card',
  standalone: true,
  imports: [NgFor, NgIf, RouterLink, TagBadgesComponent],
  templateUrl: './question-card.component.html',
  styleUrl: './question-card.component.css'
})
export class QuestionCardComponent {
  private _question!: QuestionMetadata;
  public get question(): QuestionMetadata {
    return this._question;
  }
  @Input() public set question(value: QuestionMetadata) {
    this._question = value;
    this.qService.getQuestionBody(this.question.id).then((val) => {
      this.body = val;
    });
  }
  private _body: string = "";
  public set body(value: string) {
    if (value.length > 500) {
      this._body = value.substring(0, 500) + "...";
    } else {
      this._body = value;
    }
  }
  public get body(): string {
    return this._body;
  }

  constructor(private qService: QueryService) { }
}
