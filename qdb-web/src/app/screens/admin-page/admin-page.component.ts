import { NgFor, NgIf } from '@angular/common';
import { AfterViewInit, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserMetadata } from '../../entities/UserMetadata';
import { AlertService } from '../../services/alert.service';
import { QueryService } from '../../services/query.service';
import { UserAction, UserCardComponent } from './user-card/user-card.component';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [NgIf, NgFor, UserCardComponent, FormsModule, NgIf],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
})
export class AdminPageComponent implements AfterViewInit {
  public hasRights = true;
  public users: UserMetadata[] = [];
  public currentAction: UserAction | undefined;
  public actionReceiver(action: UserAction) {
    this.currentAction = action;
    switch (action.action) {
      case 'CHANGE_PASSWORD':
        document.getElementById("change-password-modal-opener")!.click();
        break;
      case 'CHANGE_RANK':
        document.getElementById("change-rank-modal-opener")!.click();
        break;
      case 'DELETE_USER':
        document.getElementById("delete-account-modal-opener")!.click();
        break;
    }
  }
  public updatedPassword: string = "";
  public updatedRank: "SUPERUSER" | "ADMIN" | "NORMAL" | "RESTRICTED" | null = null;

  public constructor(public qService: QueryService, private aService: AlertService, private router: Router) {
    this.updateList();
  }

  ngAfterViewInit(): void {
    document.getElementById("change-password-modal")!.addEventListener("hidden.bs.modal", (e: Event) => {
      this.updatedPassword = "";
      document.getElementById("new-password-field")!.classList.remove("is-invalid");
    });
    document.getElementById("change-rank-modal")!.addEventListener("show.bs.modal", (e: Event) => {
      for (let i of this.users) {
        if (this.currentAction?.selectedUsername == i.userName) {
          this.updatedRank = i.rank;
        }
      }
    });
  }

  private updateList() {
    this.qService.getAllUserMetadata().then(async (res) => {
      if (res.status == 200) {
        this.users = await res.json() as UserMetadata[];
      } else {
        this.hasRights = false;
      }
    });
  }

  public changePasswordButtonHandler(e: Event) {
    e.preventDefault();
    if (this.updatedPassword == "") {
      let field = document.getElementById("new-password-field")! as HTMLInputElement;
      if (field.value == "") {
        field.classList.add("is-invalid");
        return;
      }
    }
    this.qService.setUserPassword(this.currentAction?.selectedUsername!, this.updatedPassword).then(async (res) => {
      if (res.status == 200) {
        this.aService.pushAlert("SUCCESS", "Successfully changed password");
      } else {
        this.aService.pushAlert("ERROR", await res.text());
      }
    });
  }

  public changeRankButtonHandler() {
    this.qService.setRank(this.currentAction?.selectedUsername!, this.updatedRank!).then(async (res) => {
      if (res.status == 200) {
        this.aService.pushAlert("SUCCESS", "Successfully changed rank");
        this.updateList();
      } else {
        this.aService.pushAlert("ERROR", await res.text());
      }
    });
  }

  public deleteAccountButtonHandler() {
    this.qService.deleteUser(this.currentAction?.selectedUsername!).then(async (res) => {
      if (res.status == 204) {
        this.aService.pushAlert("SUCCESS", "Successfully deleted user");
        this.updateList();
      } else {
        this.aService.pushAlert("ERROR", await res.text());
      }
    });
  }

  public goToLogPage() {
    this.router.navigate(["log"]);
  }
}
