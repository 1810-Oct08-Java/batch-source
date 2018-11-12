import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserComponent5Component } from './user-component5.component';

describe('UserComponent5Component', () => {
  let component: UserComponent5Component;
  let fixture: ComponentFixture<UserComponent5Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserComponent5Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserComponent5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
