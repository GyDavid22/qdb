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
  @Input() totalCount: number | undefined;
  @Output() selectedPagesize = new EventEmitter<number | undefined>();
  private _pageSize: number | undefined = PaginatingComponent.DEFAULT_PAGESIZE;

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
  }
}

interface PageSize {
  value: number | undefined,
  display: string
}
