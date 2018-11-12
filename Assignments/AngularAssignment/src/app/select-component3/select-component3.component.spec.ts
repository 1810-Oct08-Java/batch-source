import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectComponent3Component } from './select-component3.component';

describe('SelectComponent3Component', () => {
  let component: SelectComponent3Component;
  let fixture: ComponentFixture<SelectComponent3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectComponent3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectComponent3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
