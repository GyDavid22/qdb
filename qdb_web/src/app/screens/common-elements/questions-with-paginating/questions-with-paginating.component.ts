import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionMetadataList } from '../../../entities/QuestionMetadataList';
import { QueryService } from '../../../services/query.service';
import { CommonMethods } from '../common-methods';
import { QuestionCardComponent } from './question-card/question-card.component';

@Component({
  selector: 'app-questions-with-paginating',
  standalone: true,
  imports: [QuestionCardComponent, NgFor, FormsModule, NgIf],
  templateUrl: './questions-with-paginating.component.html',
  styleUrl: './questions-with-paginating.component.css'
})
export class QuestionsWithPaginatingComponent {
  @Input() public message: string = "";
  private _listingType: "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | undefined;
  @Input() public set listingType(val: "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | undefined) {
    this._listingType = val;
    if (this._listingType === "GENERAL" || this._listingType === "SEARCH") {
      this.setSearchParams();
    }
    this.updateEntries();
  }
  public get listingType(): "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | undefined {
    return this._listingType;
  }
  private _questions: QuestionMetadataList | undefined;
  public get questions(): QuestionMetadataList | undefined {
    return this._questions;
  }
  public set questions(val: QuestionMetadataList | undefined) {
    if (val !== undefined) {
      if (val.resultsCount === 0) {
        this.noQuestions = true;
      } else {
        this.noQuestions = false;
      }
    }
    this._questions = val;
  }
  public pageIndex: number = 0;
  private _pageSize: number = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
  public set pageSize(val: number | string) {
    if (typeof val == "string") {
      val = parseInt(val);
    }
    this._pageSize = val;
    try {
      sessionStorage.setItem("selectedPageSize", JSON.stringify(val));
    } catch (ReferenceError) { }
    this.pageIndex = 0;
  }
  public get pageSize(): number {
    return this._pageSize;
  }
  public search: string | undefined;
  public searchType: "ALL" | "TITLE" | "BODY" | undefined;
  public tags: string[] | undefined;
  private _titleOnly: boolean;
  public set titleOnly(val: boolean) {
    sessionStorage.setItem("showTitleOnly", JSON.stringify(val));
    this._titleOnly = val;
  }
  public get titleOnly(): boolean {
    return this._titleOnly;
  }
  public tagsValueRaw: string = "";
  public pageNumbers: number[] = [];
  public static readonly DEFAULT_PAGESIZE = 25;
  public pageSizes: PageSize[] = [
    {
      value: 25,
      display: "25"
    },
    {
      value: 50,
      display: "50"
    },
    {
      value: 100,
      display: "100"
    },
    {
      value: -1,
      display: "All"
    }
  ];
  public showReportedOnly: boolean = false;
  public isLoading: boolean = true;
  public noQuestions: boolean = false;
  public get pageSizeForm(): number {
    return this.pageSize;
  }
  public set pageSizeForm(val: number) {
    this.pageSize = val;
    this.updateEntries();
  }

  public constructor(private qService: QueryService, private route: ActivatedRoute, private router: Router) {
    let titleOnlyStorage: string | null = null;
    try {
      titleOnlyStorage = sessionStorage.getItem("showTitleOnly");
    } catch (ReferenceError) { } // there shouldn't be an error here, it just throws a message in ng serve
    if (titleOnlyStorage === null) {
      this._titleOnly = true;
    } else {
      this._titleOnly = JSON.parse(titleOnlyStorage);
    }
    let pageSizeStorage: string | null = null;
    try {
      pageSizeStorage = sessionStorage.getItem("selectedPageSize");
    } catch (ReferenceError) { } // there shouldn't be an error here, it just throws a message in ng serve
    if (pageSizeStorage === null) {
      this.pageSize = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
    } else {
      let storedValue = parseInt(JSON.parse(pageSizeStorage));
      if (Number.isNaN(storedValue) || (storedValue !== -1 && storedValue <= 0)) {
        this.pageSize = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
      } else {
        this.pageSize = storedValue;
      }
    }
  }

  private setSearchParams() {
    this.route.queryParams.subscribe((params) => {
      this.pageIndex = parseInt(params["pageNumber"] ?? 0);
      if (params["pageSize"]) {
        this._pageSize = params["pageSize"];
      }
      this.search = params["search"] ?? "";
      this.searchType = params["searchType"] ?? "ALL";
      this.tags = params["tags"] ?? undefined;
      this.showReportedOnly = params["reportedOnly"] === "true";
      this.setTagsRaw();
      this.isLoading = true;
      this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize == -1 ? undefined : this._pageSize, this.search, this.searchType, this.tags, this.showReportedOnly)
        .then((value) => {
          this.isLoading = false;
          this.questions = value;
          this.pageNumbers = this.pageOptions();
        });
    });
  }

  public async searchButtonHandler(e: Event) {
    e.preventDefault();
    this.pageIndex = 0;
    this.tags = this.tagsValueRaw.split(/[, ]/);
    for (let i = 0; i < this.tags.length; i++) {
      if (this.tags[i] == "") {
        this.tags.splice(i, 1);
        i--;
      }
    }
    this.updateEntries();
  }

  public setPageIndex(val: number) {
    this.pageIndex = val;
    this.updateEntries();
  }

  private setTagsRaw() {
    if (this.tags !== undefined) {
      if (typeof this.tags == "string") {
        this.tagsValueRaw = this.tags;
      } else {
        this.tagsValueRaw = this.tags.join(",");
      }
    }
  }

  private updateSearch() {
    this.router.navigate([], {
      queryParams: {
        "search": this.search,
        "searchType": this.searchType,
        "tags": this.tags,
        "pageNumber": this.pageIndex,
        "pageSize": this.pageSize == -1 ? undefined : this.pageSize,
        "reportedOnly": this.showReportedOnly
      },
      queryParamsHandling: "merge"
    });
  }

  private updateEntries() {
    if (this._listingType === "GENERAL" || this._listingType === "SEARCH") {
      this.updateSearch();
    } else if (this._listingType === "PERUSER") {
      this.fetchForUser();
    } else if (this._listingType === "FAVORITES") {
      this.fetchFavoritesForUser();
    }
  }

  private async fetchForUser() {
    this.isLoading = true;
    this.questions = await this.qService.getCurrentUserQuestions(this.pageSize == -1 ? undefined : this.pageSize, this.pageIndex) as QuestionMetadataList;
    this.isLoading = false;
    this.pageNumbers = this.pageOptions();
  }

  private async fetchFavoritesForUser() {
    this.isLoading = true;
    this.questions = await (await this.qService.getFavoritesForCurrentUser()).json() as QuestionMetadataList;
    this.isLoading = false;
    this.pageNumbers = this.pageOptions();
  }

  private pageOptions(): number[] {
    return CommonMethods.pageOptions(this.questions?.resultsCount!, this.pageSize, this.pageIndex);
  }

  public getClass(pageNumber: number): string {
    return CommonMethods.getPaginatingClass(pageNumber, this.pageIndex);
  }

  public resetSearch() {
    this.search = "";
    this.searchType = "ALL";
    this.tagsValueRaw = "";
    this.showReportedOnly = false;
  }
}

export interface PageSize {
  value: number,
  display: string;
}