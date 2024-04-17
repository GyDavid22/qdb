import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogScreenComponent } from './log-screen.component';

describe('LogScreenComponent', () => {
  let component: LogScreenComponent;
  let fixture: ComponentFixture<LogScreenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LogScreenComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LogScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
