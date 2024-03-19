import { Component, Input } from '@angular/core';
import { QuestionMetadataList } from '../../../entities/QuestionMetadataList';
import { PaginatingComponent } from './paginating/paginating.component';
import { QueryService } from '../../../services/query.service';
import { QuestionCardComponent } from './question-card/question-card.component';
import { NgFor } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-questions-with-paginating',
  standalone: true,
  imports: [PaginatingComponent, QuestionCardComponent, NgFor],
  templateUrl: './questions-with-paginating.component.html',
  styleUrl: './questions-with-paginating.component.css'
})
export class QuestionsWithPaginatingComponent {
  @Input() public message: string = "";
  @Input() public set searchMode(mode: boolean | undefined) {
    this._searchmode = mode;
    if (mode) {
      this.setSearchParams();
    }
    this.performQuery();
  }
  private _searchmode: boolean | undefined;
  public questions: QuestionMetadataList | undefined;
  public pageIndex: number = 0;
  private _pageSize: number | undefined = PaginatingComponent.DEFAULT_PAGESIZE;
  public set pageSize(val: number | undefined) {
    this._pageSize = val;
    this.performQuery();
  }
  public get pageSize(): number | undefined {
    return this._pageSize;
  }
  private _search: string | undefined;
  public get search(): string | undefined {
    return this._search;
  }
  private searchType: "ALL" | "TITLE" | "BODY" | undefined;
  public tags: string[] | undefined;

  public constructor(private qService: QueryService, private route: ActivatedRoute) { }

  private performQuery() {
    if (this._searchmode !== undefined) {
      if (this._searchmode) {
        this.performQuerySearch();
      } else {
        this.performQueryRegular();
      }
    }
  }

  private performQueryRegular() {
    this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize).then((value) => {
      this.questions = value;
    });
  }

  private performQuerySearch() {
    this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize, this._search, this.searchType, this.tags)
      .then((value) => {
        this.questions = value;
      });
  }

  private setSearchParams() {
    this.route.queryParams.subscribe((params) => {
      this.pageIndex = params["pageNumber"] ?? 0;
      this._pageSize = params["pageSize"] ?? PaginatingComponent.DEFAULT_PAGESIZE;
      this._search = params["search"] ?? "";
      this.searchType = params["searchType"] ?? "ALL";
      this.tags = params["tags"] ?? undefined;
      this.performQuerySearch();
    });
  }
}
