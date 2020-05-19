import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EbookDetailComponent } from './ebook-detail.component';

describe('EbookDetailComponent', () => {
  let component: EbookDetailComponent;
  let fixture: ComponentFixture<EbookDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EbookDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EbookDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
