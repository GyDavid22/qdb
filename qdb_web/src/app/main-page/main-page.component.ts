import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { QueryService } from '../services/query.service';
import { TagResponse } from '../entities/TagResponse';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [NgFor],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css'
})
export class MainPageComponent {
  private _tagsWithCount: TagResponse[] = [];
  public set tagsWithCount(value: TagResponse[]) {
    this._tagsWithCount = value;
  }
  public get tagsWithCount(): TagResponse[] {
    return this._tagsWithCount;
  }

  constructor(public qService: QueryService) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });
  }
}
