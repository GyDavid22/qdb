import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-alert',
  standalone: true,
  imports: [],
  templateUrl: './alert.component.html',
  styleUrl: './alert.component.css'
})
export class AlertComponent {
  @Input() message: string = "";
  @Input() type!: "ERROR" | "INFO" | "SUCCESS";
  private static count = 0;
  public selfname: string;

  constructor() {
    this.selfname = `alert-message-${AlertComponent.count}`;
    AlertComponent.count++;
    setTimeout(() => {
      let closeButton = document.getElementById(this.selfname) as HTMLButtonElement;
      if (closeButton) {
        closeButton.click();
      }
    }, 5000);
  }

  public get typeClass(): string {
    switch (this.type) {
      case "ERROR":
        return "alert-danger";
      case "INFO":
        return "alert-primary";
      case "SUCCESS":
        return "alert-success";
      default:
        return "";
    }
  }
}
