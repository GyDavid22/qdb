import { Component, Type } from '@angular/core';
import { QueryService } from '../services/query.service';
import { NgComponentOutlet, NgFor, NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AlertComponent } from '../screens/common-elements/alert/alert.component';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-bar',
  standalone: true,
  imports: [NgIf, RouterLink, AlertComponent, NgComponentOutlet, NgFor, FormsModule],
  templateUrl: './header-bar.component.html',
  styleUrl: './header-bar.component.css'
})
export class HeaderBarComponent {
  public errorList: { component: Type<any>, inputs: Record<string, unknown> }[] = [];
  public searchText: string = "";
  public get isLoggedIn(): boolean {
    return this.qService.isLoggedIn;
  }
  public get username(): string {
    return this.qService.username;
  }

  public constructor(private qService: QueryService, private router: Router) { }

  public async loginButtonHandler(e: Event) {
    e.preventDefault();
    let username = document.getElementById("username_login_field") as HTMLInputElement;
    username.classList.remove("is-invalid");
    let password = document.getElementById("password_login_field") as HTMLInputElement;
    password.classList.remove("is-invalid");
    if (!username.value || !password.value) {
      if (!username.value) {
        username.classList.add("is-invalid");
      }
      if (!password.value) {
        password.classList.add("is-invalid");
      }
      return;
    }
    let result = await this.qService.login(username.value, password.value);
    if (!result) {
      this.errorList.push({
        component: AlertComponent,
        inputs: {
          type: "ERROR",
          message: "Wrong username or password"
        }
      });
      setTimeout(() => {
        this.errorList.splice(0, 1);
      }, 10000);
    }
  }

  public logoutButtonHandler(e: Event) {
    e.preventDefault();
    this.qService.logout();
  }

  public searchButtonHandler(e: Event) {
    e.preventDefault();
    let searchField = document.getElementById("search_field") as HTMLInputElement;
    searchField.classList.remove("is-invalid");
    if (!searchField.value) {
      searchField.classList.add("is-invalid");
      return;
    }
    this.router.navigate(["/search"], {
      queryParams: {
        "search": this.searchText
      }
    });
  }
}
