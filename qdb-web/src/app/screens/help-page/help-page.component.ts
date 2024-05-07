import { Component } from '@angular/core';

@Component({
  selector: 'app-help-page',
  standalone: true,
  imports: [],
  templateUrl: './help-page.component.html',
  styleUrl: './help-page.component.css'
})
export class HelpPageComponent {
  public jsonText = `[
    {
        "title": "Hello world in Markdown",
        "text": "**Hello world**\\n\\nSecond line"
    },
    {
        "title": "Second question, no text",
        "text": ""
    }
]`;

  navigateToSection(id: string) {
    window.location.hash = "";
    window.location.hash = id;
  }
}
