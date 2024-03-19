import { Component, Input, SecurityContext } from '@angular/core';
import { QuestionMetadata } from '../../../../entities/QuestionMetadata';
import { NgFor, NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';
import { QueryService } from '../../../../services/query.service';
import { TagBadgesComponent } from '../../tags-box/tag-badges/tag-badges.component';
import { marked } from 'marked';
import { DomSanitizer } from '@angular/platform-browser';

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
  }
  @Input() public selfNumber: number | undefined;
  @Input() public set titleOnly(val: boolean | undefined) {
    this._titleOnly = val;
    if (val === false) {
      this.qService.getQuestionBody(this.question.id).then((val) => {
        this.body = val;
      });
    }
  }
  public get titleOnly(): boolean | undefined {
    return this._titleOnly;
  }
  private _titleOnly: boolean | undefined;
  private _body: string | null = "";
  public set body(value: string) {
    if (value.length > 500) {
      this._body = value.substring(0, 500) + "...";
    } else {
      this._body = value;
    }
    this._body = this.sanitizer.sanitize(SecurityContext.HTML, marked.parse(this._body));
  }
  public get body(): string | null {
    return this._body;
  }

  constructor(private qService: QueryService, private sanitizer: DomSanitizer) { }
}
