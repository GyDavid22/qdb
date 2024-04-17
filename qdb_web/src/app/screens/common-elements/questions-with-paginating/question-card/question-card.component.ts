import { NgFor, NgIf } from '@angular/common';
import { Component, Input, SecurityContext } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { RouterLink } from '@angular/router';
import { marked } from 'marked';
import { Constants } from '../../../../../constants';
import { QuestionMetadata } from '../../../../entities/QuestionMetadata';
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
    this.title = value.title;
  }
  @Input() public selfNumber: number | undefined;
  @Input() public set titleOnly(val: boolean | undefined) {
    this._titleOnly = val;
    if (val === false) {
      this._body = "";
      this.isLoading = true;
      this.qService.getQuestionBody(this.question.id).then((val) => {
        this.body = val;
        this.isLoading = false;
      });
    }
  }
  private highlightSet: boolean = false;
  @Input() public set highlight(val: string | undefined) {
    if (!this.highlightSet && this._highlight === undefined && val !== undefined) {
      this._highlight = val;
      this.title = this.replaceWithHighlight(this.title);
    }
    this.highlightSet = true;
  }
  public get highlight(): string | undefined {
    return this._highlight;
  }
  private _highlight: string | undefined;
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
    for (let i of this.question!.imagesUrls) {
      let imagename = i.substring(i.lastIndexOf("/") + 1);
      this._body = this._body.replace(imagename, `${Constants.WEBPAGE_URL}java/api/image/${imagename}`);
    }
    if (this.highlight !== undefined) {
      this._body = this.replaceWithHighlight(this._body);
    }
    this._body = this.sanitizer.sanitize(SecurityContext.HTML, marked.parse(this._body));
  }
  public get body(): string | null {
    return this._body;
  }
  private _title: string = "";
  public get title(): string {
    return this._title;
  }
  public set title(val: string) {
    this._title = this.sanitizer.sanitize(SecurityContext.HTML, val)!;
  }
  public isLoading: boolean = false;

  constructor(private qService: QueryService, private sanitizer: DomSanitizer) { }

  private replaceWithHighlight(text: string): string {
    if (this.highlight !== undefined) {
      let splitted = this.highlight.split(/[, !;?.]/).sort((a, b) => b.length - a.length);
      for (let i of splitted) {
        if (i == "") {
          continue;
        }
        let lowercase = text.toLowerCase();
        let highlightLowercase = i.toLowerCase();
        let index = lowercase.indexOf(highlightLowercase, 0);
        let lastIndex = 0;
        while (index !== -1) {
          let indexOfPrevBeginningTag = lowercase.indexOf("<mark>", lastIndex);
          let indexOfNextEndingTag = lowercase.indexOf("</mark>", index);
          if (indexOfPrevBeginningTag !== -1 && indexOfNextEndingTag !== -1 &&
            indexOfPrevBeginningTag <= index && indexOfNextEndingTag + 7 > index) {
            lastIndex = index;
            index = lowercase.indexOf(highlightLowercase, indexOfNextEndingTag + 7);
            continue;
          }
          let replaceValue = `<mark>${text.substring(index, index + i.length)}</mark>`;
          text = text.substring(0, index) + replaceValue + text.substring(index + i.length);
          lowercase = text.toLowerCase();
          lastIndex = index;
          index = lowercase.indexOf(highlightLowercase, index + replaceValue.length);
        }
      }
    }
    return text;
  }
}
