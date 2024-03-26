import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageListCardComponent } from './image-list-card.component';

describe('ImageListCardComponent', () => {
  let component: ImageListCardComponent;
  let fixture: ComponentFixture<ImageListCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageListCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ImageListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
