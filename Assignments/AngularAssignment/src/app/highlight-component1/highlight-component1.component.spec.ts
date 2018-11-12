import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HighlightComponent1Component } from './highlight-component1.component';

describe('HighlightComponent1Component', () => {
  let component: HighlightComponent1Component;
  let fixture: ComponentFixture<HighlightComponent1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HighlightComponent1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HighlightComponent1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
