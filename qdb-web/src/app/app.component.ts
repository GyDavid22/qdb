import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderBarComponent } from './header-bar/header-bar.component';
import { QueryService } from './services/query.service';
import { AlertHolderComponent } from './alert-holder/alert-holder.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderBarComponent, AlertHolderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'qdb_web';

  public constructor(private qService: QueryService) {
    this.qService.login();
  }
}
