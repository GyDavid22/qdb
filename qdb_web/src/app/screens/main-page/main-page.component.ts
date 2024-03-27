import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { QueryService } from '../../services/query.service';
import { TagResponse } from '../../entities/TagResponse';
import { TagsBoxComponent } from '../common-elements/tags-box/tags-box.component';
import { QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [TagsBoxComponent, QuestionsWithPaginatingComponent, RouterLink, NgIf],
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
