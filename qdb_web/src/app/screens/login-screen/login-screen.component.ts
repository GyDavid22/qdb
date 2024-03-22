import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QueryService } from '../../services/query.service';
import { AlertService } from '../../services/alert.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-screen',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './login-screen.component.html',
  styleUrl: './login-screen.component.css'
})
export class LoginScreenComponent {
  public isInRegistrationMode: boolean = false;
  public username: string = "";
  public password: string = "";
  public passwordRepeat: string = "";

  public constructor(private qService: QueryService, private aService: AlertService, private router: Router) { }

  public setToRegistrationMode(e: Event) {
    e.preventDefault();
    this.isInRegistrationMode = true;
    if (this.qService.isLoggedIn) {
      this.router.navigate([""]);
    }
  }

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
    if (!result.ok) {
      this.aService.pushAlert("ERROR", await result.text());
    } else {
      this.router.navigate([""]);
    }
  }

  public async registrationButtonHandler(e: Event) {
    e.preventDefault();
    let username = document.getElementById("username_login_field") as HTMLInputElement;
    username.classList.remove("is-invalid");
    let password = document.getElementById("password_login_field") as HTMLInputElement;
    password.classList.remove("is-invalid");
    let repassword = document.getElementById("repassword_login_field") as HTMLInputElement;
    repassword.classList.remove("is-invalid");
    if (!username.value || !password.value || !repassword.value) {
      if (!username.value) {
        username.classList.add("is-invalid");
      }
      if (!password.value) {
        password.classList.add("is-invalid");
      }
      if (!repassword.value) {
        repassword.classList.add("is-invalid");
      }
      return;
    }
    if (password.value != repassword.value) {
      password.classList.add("is-invalid");
      repassword.classList.add("is-invalid");
      this.aService.pushAlert("ERROR", "Passwords don't match");
      return;
    }
    let response = await this.qService.registration(username.value, password.value);
    if (response.status == 200) {
      this.aService.pushAlert("SUCCESS", await response.text());
    } else {
      this.aService.pushAlert("ERROR", await response.text());
    }
  }
}
