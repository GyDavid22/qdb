import { NgIf } from '@angular/common';
import { AfterViewInit, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Subject } from 'rxjs';
import { UserMetadata } from '../../entities/UserMetadata';
import { AlertService } from '../../services/alert.service';
import { QueryService } from '../../services/query.service';
import { QuestionsWithPaginatingComponent } from '../common-elements/questions-with-paginating/questions-with-paginating.component';

@Component({
  selector: 'app-user-overview',
  standalone: true,
  imports: [NgIf, FormsModule, RouterLink, QuestionsWithPaginatingComponent],
  templateUrl: './user-overview.component.html',
  styleUrl: './user-overview.component.css'
})
export class UserOverviewComponent implements AfterViewInit {
  public userMetadata: UserMetadata | undefined;
  public oldPassword: string = "";
  public newPassword: string = "";
  public newRePassword: string = "";
  public requestUpdate: Subject<void> = new Subject<void>();

  public constructor(public qService: QueryService, private aService: AlertService, private router: Router) {
    (async () => {
      let response = await this.qService.getCurrentUserMetadata();
      if (response.status == 200) {
        this.userMetadata = await (response).json() as UserMetadata;
      }
    })();
  }

  ngAfterViewInit(): void {
    let button: HTMLInputElement;
    try {
      button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    } catch { return; }
    button.addEventListener("change", () => {
      let formdata = new FormData();
      formdata.append("file", button.files?.item(0) as File);
      let xhr = new XMLHttpRequest();
      xhr.open("POST", this.qService.getCurrentProfilePictureUrl());
      xhr.withCredentials = true;
      xhr.addEventListener("loadend", () => {
        if (xhr.status == 200) {
          location.reload();
        } else if (xhr.responseText == "" || xhr.status == 413) {
          this.aService.pushAlert("ERROR", "Please upload an image smaller than 5MB");
        } else {
          this.aService.pushAlert("ERROR", xhr.responseText);
        }
        button.value = "";
      });
      xhr.send(formdata);
    });
    try {
      button = document.getElementById("browsefilebuttonjson")! as HTMLInputElement;
    } catch { return; }
    button.addEventListener("change", () => {
      let formdata = new FormData();
      formdata.append("file", button.files?.item(0) as File);
      let xhr = new XMLHttpRequest();
      xhr.open("POST", this.qService.getJsonPostUrl());
      xhr.withCredentials = true;
      xhr.addEventListener("loadend", () => {
        if (xhr.status == 201) {
          this.aService.pushAlert("SUCCESS", "Questions successfully imported");
          this.requestUpdate.next();
        } else if (xhr.status == 413) {
          this.aService.pushAlert("ERROR", "Please upload a file smaller than 5MB");
        } else {
          this.aService.pushAlert("ERROR", xhr.responseText);
        }
        button.value = "";
      });
      xhr.send(formdata);
    });
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
    let response = await this.qService.setCurrentUserPassword(this.oldPassword, this.newPassword);
    if (response.status == 200) {
      this.aService.pushAlert("SUCCESS", "Password successfully changed");
    } else {
      this.aService.pushAlert("ERROR", await response.text());
    }
  }

  public async deleteAccountButtonHandler(e: Event) {
    e.preventDefault();
    let response = await this.qService.deleteCurrentUser();
    if (response.status == 200) {
      this.aService.pushAlert("SUCCESS", "Your account has been deleted successfully");
      this.router.navigate([""]);
    } else {
      this.aService.pushAlert("ERROR", await response.text());
    }
  }

  public async updateProfilePicture(e: Event) {
    let button = document.getElementById("browsefilebutton")! as HTMLInputElement;
    button.click();
  }

  public async uploadJson(e: Event) {
    let button = document.getElementById("browsefilebuttonjson")! as HTMLInputElement;
    button.click();
  }

  public async resetProfilePicture() {
    await this.qService.resetProfilePicture();
    location.reload();
  }
}
