import { Component, Input } from '@angular/core';
import { count } from 'console';

@Component({
  selector: 'app-error-alert',
  standalone: true,
  imports: [],
  templateUrl: './error-alert.component.html',
  styleUrl: './error-alert.component.css'
})
export class ErrorAlertComponent {
  @Input() message: string = "";
  private static count = 0;
  public selfname: string;

  constructor() {
    this.selfname = `login-error-message-${ErrorAlertComponent.count}`;
    ErrorAlertComponent.count++;
    setTimeout(() => {
      let closeButton = document.getElementById(this.selfname) as HTMLButtonElement;
      if (closeButton) {
        closeButton.click();
      }
    }, 5000);
  }
}
