import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QueryService } from '../../services/query.service';
import { AlertService } from '../../services/alert.service';

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

  public constructor(private qService: QueryService, private aService: AlertService) { }

  public setToRegistrationMode(e: Event) {
    e.preventDefault();
    this.isInRegistrationMode = true;
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
    if (!result) {
      this.aService.pushAlert("ERROR", "Invalid username or password");
    }
  }
}
