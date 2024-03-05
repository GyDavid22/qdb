import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { QuestionsPagedComponent } from '../common-elements/questions-paged/questions-paged.component';

@Component({
  selector: 'app-search-screen',
  standalone: true,
  imports: [NgIf, QuestionsPagedComponent],
  templateUrl: './search-screen.component.html',
  styleUrl: './search-screen.component.css'
})
export class SearchScreenComponent {
  public params: Params | undefined;
  public search: string | undefined;

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe((value) => {
      this.params = value;
      this.search = this.params["search"];
    });
  }
}
