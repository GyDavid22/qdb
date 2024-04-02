import { Component, Input } from '@angular/core';
import { QuestionMetadataList } from '../../../entities/QuestionMetadataList';
import { PaginatingComponent } from './paginating/paginating.component';
import { QueryService } from '../../../services/query.service';
import { QuestionCardComponent } from './question-card/question-card.component';
import { NgFor, NgIf } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-questions-with-paginating',
  standalone: true,
  imports: [PaginatingComponent, QuestionCardComponent, NgFor, FormsModule, NgIf],
  templateUrl: './questions-with-paginating.component.html',
  styleUrl: './questions-with-paginating.component.css'
})
export class QuestionsWithPaginatingComponent {
  @Input() public message: string = "";
  @Input() public set searchMode(mode: boolean | undefined) {
    this._searchmode = mode;
    if (mode) {
      this.setSearchParams();
    } else {
      this.performQuery();
    }
  }
  public get searchMode(): boolean | undefined {
    return this._searchmode;
  }
  private _searchmode: boolean | undefined;
  public questions: QuestionMetadataList | undefined;
  public _pageIndex: number = 0;
  public get pageIndex(): number {
    return this._pageIndex;
  }
  public set pageIndex(val: number) {
    this._pageIndex = val;
  }
  private _pageSize: number | undefined;
  public set pageSize(val: number | undefined) {
    this._pageSize = val;
    if (val === undefined) {
      sessionStorage.setItem("selectedPageSize", JSON.stringify("ALL"));
    } else {
      sessionStorage.setItem("selectedPageSize", JSON.stringify(val));
    }
    this._pageIndex = 0;
  }
  public get pageSize(): number | undefined {
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

  public constructor(private qService: QueryService, private route: ActivatedRoute, private router: Router) {
    let titleOnlyStorage = sessionStorage.getItem("showTitleOnly");
    if (titleOnlyStorage === null) {
      this._titleOnly = true;
    } else {
      this._titleOnly = JSON.parse(titleOnlyStorage);
    }
    let pageSizeStorage = sessionStorage.getItem("selectedPageSize");
    if (pageSizeStorage === null) {
      this.pageSize = PaginatingComponent.DEFAULT_PAGESIZE;
    } else {
      let storedValue = JSON.parse(pageSizeStorage);
      if (storedValue == "ALL") {
        this.pageSize = undefined;
      } else {
        this.pageSize = storedValue;
      }
    }
  }

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
    this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize, this.search, this.searchType, this.tags)
      .then((value) => {
        this.questions = value;
      });
  }

  private setSearchParams() {
    this.route.queryParams.subscribe((params) => {
      this.pageIndex = params["pageNumber"] ?? 0;
      if (params["pageSize"]) {
        this._pageSize = params["pageSize"];
      }
      this.search = params["search"] ?? "";
      this.searchType = params["searchType"] ?? "ALL";
      this.tags = params["tags"] ?? undefined;
      this.setTagsRaw();
      this.performQuerySearch();
    });
  }

  public async searchButtonHandler(e: Event) {
    e.preventDefault();
    this._pageIndex = 0;
    this.tags = this.tagsValueRaw.split(",");
    this.updateSearch();
  }

  public setPageSize(val: number | undefined) {
    this.pageSize = val;
    this.updateSearch();
  }

  public setPageIndex(val: number) {
    this.pageIndex = val;
    this.updateSearch();
  }

  public setTagsRaw() {
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
        "pageSize": this.pageSize
      },
      queryParamsHandling: "merge"
    });
  }
}
