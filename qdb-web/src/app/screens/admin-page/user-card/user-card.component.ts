import { Component, EventEmitter, Input, Output } from '@angular/core';
import { UserMetadata } from '../../../entities/UserMetadata';
import { QueryService } from '../../../services/query.service';

@Component({
  selector: 'app-user-card',
  standalone: true,
  imports: [],
  templateUrl: './user-card.component.html',
  styleUrl: './user-card.component.css'
})
export class UserCardComponent {
  @Input() user: UserMetadata | undefined;
  @Output() selectedUser: EventEmitter<UserAction> = new EventEmitter();

  public constructor(public qService: QueryService) { }

  public changePasswordButtonHandler() {
    this.selectedUser.emit({
      selectedUsername: this.user!.userName,
      action: "CHANGE_PASSWORD"
    });
  }

  public changeRankButtonHandler() {
    this.selectedUser.emit({
      selectedUsername: this.user!.userName,
      action: "CHANGE_RANK"
    });
  }

  public deleteUserButtonHandler() {
    this.selectedUser.emit({
      selectedUsername: this.user!.userName,
      action: "DELETE_USER"
    });
  }
}

export interface UserAction {
  selectedUsername: string,
  action: "CHANGE_PASSWORD" | "CHANGE_RANK" | "DELETE_USER"
}