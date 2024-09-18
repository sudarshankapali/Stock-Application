import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyShareComponent } from './apply-share.component';

describe('ApplyShareComponent', () => {
  let component: ApplyShareComponent;
  let fixture: ComponentFixture<ApplyShareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ApplyShareComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApplyShareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
