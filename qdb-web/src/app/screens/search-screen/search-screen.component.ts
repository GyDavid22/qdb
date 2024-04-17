import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';

@Component({
  selector: 'app-search-screen',
  standalone: true,
  imports: [QuestionsWithPaginatingComponent, NgIf],
  templateUrl: './search-screen.component.html',
  styleUrl: './search-screen.component.css'
})
export class SearchScreenComponent {
  public search: string | undefined;

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe((params) => {
      this.search = params["search"] ?? "";
    });
  }
}
