import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { QuestionMetadataList } from '../../entities/QuestionMetadataList';
import { TagResponse } from '../../entities/TagResponse';
import { AlertService } from '../../services/alert.service';
import { QueryService } from '../../services/query.service';
import { QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';
import { TagsBoxComponent } from '../common-elements/tags-box/tags-box.component';

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

  constructor(public qService: QueryService, private aService: AlertService, private router: Router) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });
  }

  public async randomQuestionButton() {
    let result: QuestionMetadataList = await (await this.qService.randomQuestion(1)).json() as QuestionMetadataList;
    if (result.resultsCount == 0) {
      this.aService.pushAlert("ERROR", "There aren't any questions yet");
    } else {
      this.router.navigate([`/question/${result.questions[0].id}`]);
    }
  }
}
