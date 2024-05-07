import { Component } from '@angular/core';
import { QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';

@Component({
  selector: 'app-random-questions-screen',
  standalone: true,
  imports: [QuestionsWithPaginatingComponent],
  templateUrl: './random-questions-screen.component.html',
  styleUrl: './random-questions-screen.component.css'
})
export class RandomQuestionsScreenComponent {
  constructor() {
    try {
      sessionStorage.setItem("lastvisit", "random");
    } catch { }
  }
}
