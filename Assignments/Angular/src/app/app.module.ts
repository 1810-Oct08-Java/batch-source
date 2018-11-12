import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HighlightDirective } from './highlight.directive';
import { ShowInfoComponent } from './show-info/show-info.component';
import { SelectComponent } from './select/select.component';
import { HighlightComponent } from './highlight/highlight.component';
import { TableComponent } from './table/table.component';

@NgModule({
  declarations: [
    AppComponent,
    HighlightDirective,
    ShowInfoComponent,
    SelectComponent,
    HighlightComponent,
    TableComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
