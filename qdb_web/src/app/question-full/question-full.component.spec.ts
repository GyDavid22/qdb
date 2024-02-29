import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionFullComponent } from './question-full.component';

describe('QuestionFullComponent', () => {
  let component: QuestionFullComponent;
  let fixture: ComponentFixture<QuestionFullComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuestionFullComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QuestionFullComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
