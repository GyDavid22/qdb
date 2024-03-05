import { Component } from '@angular/core';
import { QuestionMetadataList } from '../../entities/QuestionMetadataList';
import { QueryService } from '../../services/query.service';
import { NgFor, NgIf } from '@angular/common';
import { QuestionCardComponent } from '../common-elements/question-card/question-card.component';
import { ActivatedRoute } from '@angular/router';
import { PaginatingComponent } from '../common-elements/paginating/paginating.component';

@Component({
  selector: 'app-search-screen',
  standalone: true,
  imports: [NgFor, QuestionCardComponent, NgIf, PaginatingComponent],
  templateUrl: './search-screen.component.html',
  styleUrl: './search-screen.component.css'
})
export class SearchScreenComponent {
  public results: QuestionMetadataList | undefined;
  private pageNumber: number | undefined;
  private _pageSize: number | undefined;
  private _search: string | undefined;
  public get search(): string | undefined {
    return this._search;
  }
  private searchType: "ALL" | "TITLE" | "BODY" | undefined;
  tags: string[] | undefined;
  public set pageSizeFromPaginating(value: number | undefined) {
    this._pageSize = value;
    this.performQuery();
  }

  constructor(private qService: QueryService, private route: ActivatedRoute) {
    this.route.queryParams.subscribe((params) => {
      this.pageNumber = params["pageNumber"] ?? 0;
      this._pageSize = params["pageSize"] ?? PaginatingComponent.DEFAULT_PAGESIZE;
      this._search = params["search"] ?? "";
      this.searchType = params["searchType"] ?? "ALL";
      this.performQuery();
    });
  }

  private performQuery() {
    this.qService.getQuestionMetadataList(this.pageNumber, this._pageSize, this._search, this.searchType, this.tags)
      .then((value) => {
        this.results = value;
      });
  }
}
