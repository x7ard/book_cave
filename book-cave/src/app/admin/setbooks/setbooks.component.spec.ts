import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetbooksComponent } from './setbooks.component';

describe('SetbooksComponent', () => {
  let component: SetbooksComponent;
  let fixture: ComponentFixture<SetbooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetbooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
