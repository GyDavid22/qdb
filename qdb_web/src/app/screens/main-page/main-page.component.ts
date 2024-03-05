import { Component } from '@angular/core';
import { QueryService } from '../../services/query.service';
import { TagResponse } from '../../entities/TagResponse';
import { TagsBoxComponent } from '../common-elements/tags-box/tags-box.component';
import { QuestionsPagedComponent } from '../common-elements/questions-paged/questions-paged.component';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [TagsBoxComponent, QuestionsPagedComponent],
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

  constructor(private qService: QueryService) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });
  }
}
