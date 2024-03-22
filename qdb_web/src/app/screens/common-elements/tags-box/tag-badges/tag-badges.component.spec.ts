import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagBadgesComponent } from './tag-badges.component';

describe('TagBadgesComponent', () => {
  let component: TagBadgesComponent;
  let fixture: ComponentFixture<TagBadgesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagBadgesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TagBadgesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
