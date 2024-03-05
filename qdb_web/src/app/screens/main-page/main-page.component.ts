import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { QueryService } from '../../services/query.service';
import { TagResponse } from '../../entities/TagResponse';
import { QuestionCardComponent } from '../common-elements/question-card/question-card.component';
import { TagsBoxComponent } from '../common-elements/tags-box/tags-box.component';
import { QuestionMetadataList } from '../../entities/QuestionMetadataList';
import { PaginatingComponent } from '../common-elements/paginating/paginating.component';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [NgFor, QuestionCardComponent, TagsBoxComponent, PaginatingComponent],
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
  public questions: QuestionMetadataList | undefined;
  private pageIndex: number = 0;
  private _pageSize: number | undefined = PaginatingComponent.DEFAULT_PAGESIZE;
  public set pageSize(value: number | undefined) {
    this._pageSize = value;
    this.performQuery();
  }

  constructor(private qService: QueryService) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });
    this.performQuery();
  }

  private performQuery() {
    this.qService.getQuestionMetadataList(this.pageIndex, this._pageSize).then((value) => {
      this.questions = value;
    });
  }
}
