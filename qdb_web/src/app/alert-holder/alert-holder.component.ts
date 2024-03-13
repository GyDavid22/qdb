import { NgComponentOutlet, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { AlertService } from '../services/alert.service';

@Component({
  selector: 'app-alert-holder',
  standalone: true,
  imports: [NgFor, NgComponentOutlet],
  templateUrl: './alert-holder.component.html',
  styleUrl: './alert-holder.component.css'
})
export class AlertHolderComponent {
  constructor(public aService: AlertService) { }
}
