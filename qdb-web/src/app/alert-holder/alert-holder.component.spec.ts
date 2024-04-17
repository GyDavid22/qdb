import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlertHolderComponent } from './alert-holder.component';

describe('AlertHolderComponent', () => {
  let component: AlertHolderComponent;
  let fixture: ComponentFixture<AlertHolderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlertHolderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlertHolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
