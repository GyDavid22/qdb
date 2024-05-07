import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
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
  imports: [TagsBoxComponent, QuestionsWithPaginatingComponent, RouterLink, NgIf, FormsModule],
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
  public randomQuestionCount = 5;

  constructor(public qService: QueryService, private aService: AlertService, private router: Router) {
    this.qService.tagsWithCounts().then((value) => {
      this.tagsWithCount = value;
    });
    try {
      sessionStorage.setItem("lastvisit", "");
    } catch { }
  }

  public async multipleRandomQuestionButton() {
    let result = await this.qService.randomQuestion(this.randomQuestionCount);
    if (result.status == 200) {
      let resultJson: QuestionMetadataList = await result.json() as QuestionMetadataList;
      let ids: number[] = [];
      for (let i = 0; i < resultJson.resultsCount; i++) {
        ids.push(resultJson.questions[i].id);
      }
      sessionStorage.setItem("randomQuestionIds", JSON.stringify(ids));
      this.router.navigate(["/random"]);
    } else {
      this.aService.pushAlert("ERROR", await result.text());
    }
  }
}
