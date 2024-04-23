import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomQuestionsScreenComponent } from './random-questions-screen.component';

describe('RandomQuestionsScreenComponent', () => {
  let component: RandomQuestionsScreenComponent;
  let fixture: ComponentFixture<RandomQuestionsScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RandomQuestionsScreenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RandomQuestionsScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
