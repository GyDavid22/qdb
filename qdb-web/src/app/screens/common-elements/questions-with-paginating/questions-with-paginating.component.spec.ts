import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionsWithPaginatingComponent } from './questions-with-paginating.component';

describe('QuestionsWithPaginatingComponent', () => {
  let component: QuestionsWithPaginatingComponent;
  let fixture: ComponentFixture<QuestionsWithPaginatingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionsWithPaginatingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuestionsWithPaginatingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
