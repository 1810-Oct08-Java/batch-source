import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableComponent4Component } from './table-component4.component';

describe('TableComponent4Component', () => {
  let component: TableComponent4Component;
  let fixture: ComponentFixture<TableComponent4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableComponent4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableComponent4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
