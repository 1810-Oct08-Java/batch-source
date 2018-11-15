import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HighLightComponent } from './high-light/high-light.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponentComponent } from './select-component/select-component.component';
import { TableComponentComponent } from './table-component/table-component.component';


@NgModule({
  declarations: [
    AppComponent,
    HighLightComponent,
    ProfileComponent,
    SelectComponentComponent,
    TableComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
