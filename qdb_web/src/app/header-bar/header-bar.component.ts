import { Component, Type } from '@angular/core';
import { QueryService } from '../services/query.service';
import { NgComponentOutlet, NgFor, NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ErrorAlertComponent } from './error-alert/error-alert.component';

@Component({
  selector: 'app-header-bar',
  standalone: true,
  imports: [NgIf, RouterLink, ErrorAlertComponent, NgComponentOutlet, NgFor],
  templateUrl: './header-bar.component.html',
  styleUrl: './header-bar.component.css'
})
export class HeaderBarComponent {
  public errorList: { component: Type<any>, inputs: Record<string, unknown> }[] = [];

  public constructor(public qService: QueryService) { }

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
        component: ErrorAlertComponent,
        inputs: {
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
}
