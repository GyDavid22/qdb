import { NgFor, NgIf } from '@angular/common';
import { AfterViewInit, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LogEntryList } from '../../entities/LogEntryList';
import { AlertService } from '../../services/alert.service';
import { QueryService } from '../../services/query.service';
import { CommonMethods } from '../common-elements/common-methods';
import { PageSize, QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';

@Component({
  selector: 'app-log-screen',
  standalone: true,
  imports: [NgFor, NgIf, FormsModule],
  templateUrl: './log-screen.component.html',
  styleUrl: './log-screen.component.css'
})
export class LogScreenComponent implements AfterViewInit {
  private _pageSize: number | undefined;
  public get pageSize(): number {
    let value;
    try {
      value = sessionStorage.getItem("selectedPageSize");
    } catch (ReferenceError) { }
    if (value === null) {
      this._pageSize = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
    } else {
      let asInt = parseInt(JSON.parse(value!));
      try {
        if (Number.isNaN(asInt) || (asInt !== -1 && asInt <= 0)) {
          this._pageSize = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
        } else {
          this._pageSize = asInt;
        }
      } catch {
        this._pageSize = QuestionsWithPaginatingComponent.DEFAULT_PAGESIZE;
      }
    }
    return this._pageSize;
  }
  public set pageSize(val: number) {
    sessionStorage.setItem("selectedPageSize", JSON.stringify(val));
    this._pageSize = val;
    this.pageIndex = 0;
  }
  private _pageIndex: number = 0;
  public get pageIndex(): number {
    return this._pageIndex;
  }
  public set pageIndex(val: number) {
    this._pageIndex = val;
    this.fetchLog();
  }
  public entries: LogEntryList | undefined;
  public isLoading: boolean = true;
  public pageNumbers: number[] = [];
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

  constructor(private qService: QueryService, private aService: AlertService, private router: Router) {
    this.pageSize;
  }

  ngAfterViewInit(): void {
    this.fetchLog();
  }

  public async fetchLog(): Promise<void> {
    this.isLoading = true;
    let response = await this.qService.getLog(this.pageIndex, this.pageSize == -1 ? undefined : this.pageSize);
    if (response.status === 401) {
      this.aService.pushAlert("ERROR", "You don't have permissions to view the log");
      this.router.navigate(["404"]);
      return;
    }
    this.entries = await response.json() as LogEntryList;
    this.pageNumbers = CommonMethods.pageOptions(this.entries?.totalCount!, this.pageSize, this.pageIndex);
    this.isLoading = false;
  }

  public toLocaleString(date: string) {
    return new Date(date).toLocaleString();
  }

  public backButton() {
    history.back();
  }

  public getClass(pageNumber: number): string {
    return CommonMethods.getPaginatingClass(pageNumber, this.pageIndex);
  }
}
