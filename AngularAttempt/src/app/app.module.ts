import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AssociateViewComponent } from 'src/associate-view/associate-view.component';
import { UserComponent } from './user/user.component';
import { ProfileComponent } from './profile/profile.component';
import { AnimalComponent } from './animal/animal.component';
import { ColorComponent } from './color/color.component';
import { DayComponent } from './day/day.component';

@NgModule({
  declarations: [
    AppComponent,
    AssociateViewComponent,
    UserComponent,
    ProfileComponent,
    AnimalComponent,
    ColorComponent,
    DayComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
