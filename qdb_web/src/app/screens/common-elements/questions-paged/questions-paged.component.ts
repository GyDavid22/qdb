import { Component, Input } from '@angular/core';
import { PaginatingComponent } from '../paginating/paginating.component';
import { NgFor } from '@angular/common';
import { QuestionCardComponent } from '../question-card/question-card.component';
import { QuestionMetadataList } from '../../../entities/QuestionMetadataList';
import { QueryService } from '../../../services/query.service';
import { Params } from '@angular/router';

@Component({
  selector: 'app-questions-paged',
  standalone: true,
  imports: [PaginatingComponent, NgFor, QuestionCardComponent],
  templateUrl: './questions-paged.component.html',
  styleUrl: './questions-paged.component.css'
})
export class QuestionsPagedComponent {
  @Input() public message!: string;
  private _params: Params | undefined;
  @Input() public set params(val: Params | undefined) {
    this._params = val;
    if (this.params) {
      this.pageIndex = this.params["pageNumber"];
      this._pageSize = this.params["pageSize"];
      this.search = this.params["search"];
      this.searchType = this.params["searchType"];
      this.tags = this.params["tags"];
    }
    this.performQuery();
  }
  public get params(): Params | undefined {
    return this._params;
  }
  public questions: QuestionMetadataList | undefined;
  private pageIndex: number = 0;
  private _pageSize: number | undefined = PaginatingComponent.DEFAULT_PAGESIZE;
  public set pageSize(value: number | undefined) {
    this._pageSize = value;
    this.performQuery();
  }
  private search: string | undefined;
  private searchType: "ALL" | "TITLE" | "BODY" | undefined;
  tags: string[] | undefined;
  public set pageSizeFromPaginating(value: number | undefined) {
    this._pageSize = value;
    this.performQuery();
  }

  constructor(private qService: QueryService) { }

  private performQuery() {
    this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize, this.search, this.searchType, this.tags)
      .then((value) => {
        this.questions = value;
      });
  }
}
