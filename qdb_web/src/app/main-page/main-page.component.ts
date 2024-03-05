import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { QueryService } from '../services/query.service';
import { TagResponse } from '../entities/TagResponse';
import { QuestionCardComponent } from '../question-card/question-card.component';
import { TagsBoxComponent } from '../tags-box/tags-box.component';
import { QuestionMetadataList } from '../entities/QuestionMetadataList';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [NgFor, QuestionCardComponent, TagsBoxComponent],
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
  private pageSize: number = 50;

  constructor(public qService: QueryService) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });

    qService.getQuestionMetadataList(this.pageIndex, this.pageSize).then((value) => {
      this.questions = value;
    });
  }
}
