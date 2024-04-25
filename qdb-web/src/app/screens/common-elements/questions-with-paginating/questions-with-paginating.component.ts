import { NgFor, NgIf } from '@angular/common';
import { Component, Input, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { QuestionMetadata } from '../../../entities/QuestionMetadata';
import { QuestionMetadataList } from '../../../entities/QuestionMetadataList';
import { AlertService } from '../../../services/alert.service';
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
export class QuestionsWithPaginatingComponent implements OnDestroy {
  @Input() public message: string = "";
  private _listingType: "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | "RANDOM" | undefined;
  @Input() public set listingType(val: "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | "RANDOM" | undefined) {
    this._listingType = val;
    if (this.listingType === "GENERAL" || this.listingType === "SEARCH") {
      this.setSearchParams();
    } else if (this.listingType === "RANDOM") {
      this.subscribeToParamsRandom();
    }
    this.updateEntries();
  }
  public get listingType(): "GENERAL" | "SEARCH" | "PERUSER" | "FAVORITES" | "RANDOM" | undefined {
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
  public selectedCards: number[] = [];
  private static instanceCount = 0;
  private selfCount;
  public get selfModalId(): string {
    return `delete-selected-questions-modal-${this.selfCount}`;
  }
  private eventsSubscription: Subscription | undefined;
  private _requestReceiver: Observable<void> | undefined;
  @Input()
  public set requestReceiver(val: Observable<void> | undefined) {
    if (this.eventsSubscription !== undefined) {
      this.eventsSubscription.unsubscribe();
    }
    if (val !== undefined) {
      this._requestReceiver = val;
      this.eventsSubscription = this._requestReceiver.subscribe((val2) => {
        this.fetchForUser();
      });
    }
  }

  public constructor(public qService: QueryService, private route: ActivatedRoute, private router: Router, private aService: AlertService) {
    this.selfCount = QuestionsWithPaginatingComponent.instanceCount++;
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
  ngOnDestroy(): void {
    if (this.eventsSubscription !== undefined) {
      this.eventsSubscription.unsubscribe();
    }
  }

  private setSearchParams() {
    this.route.queryParams.subscribe(async (params) => {
      this.pageIndex = parseInt(params["pageNumber"] ?? 0);
      if (params["pageSize"]) {
        this._pageSize = params["pageSize"];
      }
      this.search = params["search"] ?? "";
      this.searchType = params["searchType"] ?? "ALL";
      this.tags = params["tags"] ?? undefined;
      this.showReportedOnly = params["reportedOnly"] === "true";
      this.setTagsRaw();
      await this.loadData();
    });
  }

  private async loadData() {
    this.isLoading = true;
    let response = await this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize == -1 ? undefined : this._pageSize, this.search, this.searchType, this.tags, this.showReportedOnly);
    if (response.status === 200) {
      this.questions = await response.json() as QuestionMetadataList;
      this.pageNumbers = this.pageOptions();
    } else if (response.status === 400 && this.pageIndex !== 0) {
      this.router.navigate([], {
        queryParams: {
          "pageNumber": 0
        },
        queryParamsHandling: "merge"
      });
    } else {
      this.questions = {
        resultsCount: 0,
        questions: []
      } as QuestionMetadataList;
      this.pageNumbers = this.pageOptions();
    }
    this.isLoading = false;
  }

  private subscribeToParamsRandom() {
    this.route.queryParams.subscribe(async (params) => {
      this.pageIndex = parseInt(params["pageNumber"] ?? 0);
      if (params["pageSize"]) {
        this._pageSize = params["pageSize"];
      }
      this.loadRandomEntries();
    });
  }

  private async loadRandomEntries() {
    this.isLoading = true;
    let storedValues: string | null = null;
    try {
      storedValues = sessionStorage.getItem("randomQuestionIds");
    } catch (e) { }
    if (storedValues !== null) {
      let ids: number[] = JSON.parse(storedValues);
      let totalCount = ids.length;
      let start = this.pageIndex * this.pageSize;
      let end = start + this.pageSize > ids.length ? undefined : start + this.pageSize;
      ids = ids.slice(start, end);
      let result = {
        resultsCount: totalCount,
        questions: []
      } as QuestionMetadataList;
      let doneCount = 0;
      for (let i = 0; i < ids.length; i++) {
        let response = await this.qService.getQuestionMetadata(ids[i]);
        if (response.status === 200) {
          result.questions.push(await response.json() as QuestionMetadata);
        }
        doneCount++;
        if (doneCount === ids.length) {
          this.questions = result;
          this.isLoading = false;
          this.pageNumbers = this.pageOptions();
        }
      }
    }
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
    if (this.listingType === "GENERAL" || this.listingType === "SEARCH") {
      this.updateSearch();
    } else if (this.listingType === "PERUSER") {
      this.fetchForUser();
    } else if (this.listingType === "FAVORITES") {
      this.fetchFavoritesForUser();
    } else if (this.listingType === "RANDOM") {
      this.updateRandomEntries();
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

  private async updateRandomEntries() {
    this.router.navigate([], {
      queryParams: {
        "pageNumber": this.pageIndex,
        "pageSize": this.pageSize == -1 ? undefined : this.pageSize
      },
      queryParamsHandling: "merge"
    });
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

  public isCardSelected(id: number): boolean {
    return this.selectedCards.includes(id);
  }

  public selectCard(isSelected: boolean, id: number) {
    if (isSelected) {
      if (!this.selectedCards.includes(id)) {
        this.selectedCards.push(id);
      }
    } else {
      if (this.selectedCards.includes(id)) {
        this.selectedCards.splice(this.selectedCards.indexOf(id), 1);
      }
    }
  }

  public downloadSelectedPdf() {
    window.location.href = this.qService.getDownloadPdfUrl(this.selectedCards);
  }

  public async deleteSelected() {
    let failed: number[] = [];
    for (let i of this.selectedCards) {
      let response = await this.qService.deleteQuestion(i);
      if (response.status !== 200) {
        failed.push(i);
      }
    }
    if (failed.length > 0) {
      this.aService.pushAlert("ERROR", `Failed to delete question(s) with id: ${failed.join(", ")}\nDo you have rights to delete them?`);
    } else {
      this.aService.pushAlert("SUCCESS", "Successfully deleted selected questions");
    }
    this.selectedCards = [];
    if (this.listingType === "GENERAL" || this.listingType === "SEARCH") {
      this.loadData();
    } else if (this.listingType === "RANDOM") {
      this.loadRandomEntries();
    } else {
      this.updateEntries();
    }
  }
}

export interface PageSize {
  value: number,
  display: string;
}