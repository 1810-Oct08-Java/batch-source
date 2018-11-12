import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HighlightComponent1Component } from './highlight-component1/highlight-component1.component';
import { ProfileComponent2Component } from './profile-component2/profile-component2.component';
import { SelectComponent3Component } from './select-component3/select-component3.component';
import { TableComponent4Component } from './table-component4/table-component4.component';
import { UserComponent5Component } from './user-component5/user-component5.component';

@NgModule({
  declarations: [
    AppComponent,
    HighlightComponent1Component,
    ProfileComponent2Component,
    SelectComponent3Component,
    TableComponent4Component,
    UserComponent5Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
 
 }
