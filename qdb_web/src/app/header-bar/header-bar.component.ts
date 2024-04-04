import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AlertComponent } from '../screens/common-elements/alert/alert.component';
import { QueryService } from '../services/query.service';

@Component({
  selector: 'app-header-bar',
  standalone: true,
  imports: [NgIf, RouterLink, AlertComponent, NgFor, FormsModule],
  templateUrl: './header-bar.component.html',
  styleUrl: './header-bar.component.css'
})
export class HeaderBarComponent {
  public searchText: string = "";
  public get isLoggedIn(): boolean {
    return this.qService.isLoggedIn;
  }
  public get username(): string {
    return this.qService.username;
  }

  public constructor(public qService: QueryService, private router: Router) { }

  public logoutButtonHandler(e: Event) {
    e.preventDefault();
    this.qService.logout();
    this.router.navigate([""]);
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
