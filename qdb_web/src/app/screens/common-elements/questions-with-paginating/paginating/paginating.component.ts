import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-paginating',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './paginating.component.html',
  styleUrl: './paginating.component.css'
})
export class PaginatingComponent {
  @Input() message!: string;
  private _totalCount: number | undefined
  @Input() public set totalCount(val: number | undefined) {
    this._totalCount = val;
    if (val !== undefined) {
      this.pageNumbers = this.pageOptions(val);
    }
  }
  public get totalCount(): number | undefined {
    return this._totalCount;
  }
  @Input() public set pageSize(val: number | undefined) {
    this._pageSize = val;
    this.pageNumbers = this.pageOptions(this.totalCount!);
  }
  @Output() selectedPagesize = new EventEmitter<number | undefined>();
  private _pageSize: number | undefined = PaginatingComponent.DEFAULT_PAGESIZE;
  @Output() selectedPageIndex = new EventEmitter<number>();
  private _pageIndex: number = 0;
  @Input() public set pageIndex(val: number) {
    this._pageIndex = val;
    this.pageNumbers = this.pageOptions(this.totalCount!);
  }
  public get pageIndex(): number {
    return this._pageIndex;
  }
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
      value: undefined,
      display: "All"
    }
  ]
  private _pageSizeFormValue: string = "default";
  public get pageSizeFormValue(): string {
    return this._pageSizeFormValue;
  }
  public set pageSizeFormValue(value: string) {
    for (let i of this.pageSizes) {
      if (i.display == value) {
        this._pageSize = i.value;
        break;
      }
    }
    this.selectedPagesize.emit(this._pageSize);
    this.pageIndex = 0;
  }

  private calcNumPages(): number {
    return Math.ceil(this.totalCount! / this._pageSize!);
  }

  public pageOptions(numpages: number): number[] {
    let result = [];
    let numOfPages = this.calcNumPages();
    for (let i = 1; i <= Math.min(numOfPages, 3); i++) {
      result.push(i);
    }
    for (let i = Math.max(this.pageIndex, 4); i <= Math.min(numOfPages, this.pageIndex + 2); i++) {
      if (!result.includes(i)) {
        result.push(i);
      }
    }
    for (let i = Math.max(1, numOfPages - 2); i <= numOfPages; i++) {
      if (!result.includes(i)) {
        result.push(i);
      }
    }
    result.sort((n1, n2) => n1 - n2);
    return result;
  }

  public getClass(pageNumber: number): string {
    if (pageNumber == this.pageIndex + 1) {
      return "page-item active";
    }
    return "page-item";
  }

  public pageIndexSetFromGui(val: number) {
    this.pageIndex = val;
    this.selectedPageIndex.emit(val);
  }
}

interface PageSize {
  value: number | undefined,
  display: string
}
