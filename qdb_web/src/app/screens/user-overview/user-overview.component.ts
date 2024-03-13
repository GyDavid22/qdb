import { Component } from '@angular/core';
import { QueryService } from '../../services/query.service';
import { UserMetadata } from '../../entities/UserMetadata';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AlertService } from '../../services/alert.service';

@Component({
  selector: 'app-user-overview',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './user-overview.component.html',
  styleUrl: './user-overview.component.css'
})
export class UserOverviewComponent {
  public userMetadata: UserMetadata | undefined;
  public oldPassword: string = "";
  public newPassword: string = "";
  public newRePassword: string = "";

  public constructor(public qService: QueryService, private aService: AlertService) {
    (async () => {
      let response = await this.qService.getCurrentUserMetadata();
      if (response.status == 200) {
        this.userMetadata = await (response).json() as UserMetadata;
      }
    })();
  }

  public async changePasswordHandler(e: Event) {
    e.preventDefault();
    let oldPassField = document.getElementById("overview-old-password") as HTMLInputElement;
    oldPassField.classList.remove("is-invalid");
    let newPassField = document.getElementById("overview-new-password") as HTMLInputElement;
    newPassField.classList.remove("is-invalid");
    let newRePassField = document.getElementById("overview-new-repassword") as HTMLInputElement;
    newRePassField.classList.remove("is-invalid");
    if (!this.oldPassword || !this.newPassword || !this.newRePassword) {
      if (!this.oldPassword) {
        oldPassField.classList.add("is-invalid");
      }
      if (!this.newPassword) {
        newPassField.classList.add("is-invalid");
      }
      if (!this.newRePassword) {
        newRePassField.classList.add("is-invalid");
      }
      return;
    }
    if (this.newPassword != this.newRePassword) {
      newPassField.classList.add("is-invalid");
      newRePassField.classList.add("is-invalid");
      this.aService.pushAlert("ERROR", "Passwords don't match");
      return;
    }
  }
}
