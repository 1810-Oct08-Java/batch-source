import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileComponent2Component } from './profile-component2.component';

describe('ProfileComponent2Component', () => {
  let component: ProfileComponent2Component;
  let fixture: ComponentFixture<ProfileComponent2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileComponent2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileComponent2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
