import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-tag-badges',
  standalone: true,
  imports: [RouterLink, NgFor],
  templateUrl: './tag-badges.component.html',
  styleUrl: './tag-badges.component.css'
})
export class TagBadgesComponent {
  @Input() tags!: string[];
}
