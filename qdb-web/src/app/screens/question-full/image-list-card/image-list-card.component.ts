import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-image-list-card',
  standalone: true,
  imports: [],
  templateUrl: './image-list-card.component.html',
  styleUrl: './image-list-card.component.css'
})
export class ImageListCardComponent {
  @Input() selfName!: string
  @Output() selectEvent = new EventEmitter<string>();
  @Output() deleteEvent = new EventEmitter<string>();
}
