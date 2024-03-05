import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';
import { TagResponse } from '../../../entities/TagResponse';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-tags-box',
  standalone: true,
  imports: [NgFor, RouterLink],
  templateUrl: './tags-box.component.html',
  styleUrl: './tags-box.component.css'
})
export class TagsBoxComponent {
  @Input() public tagsWithCount!: TagResponse[];
}
