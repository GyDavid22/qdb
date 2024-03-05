import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionsPagedComponent } from './questions-paged.component';

describe('QuestionsPagedComponent', () => {
  let component: QuestionsPagedComponent;
  let fixture: ComponentFixture<QuestionsPagedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionsPagedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuestionsPagedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
