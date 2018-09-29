import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NationComponent } from './nation/nation.component';
import { RegionComponent } from './region/region.component';
import { UnitComponent } from './unit/unit.component';
import { CommandComponent } from './command/command.component';
import { RegionService } from './region/region.service';
import { NationService } from './nation/nation.service';
import {UnitService} from './unit/unit.service';
import {CommandService} from './command/command.service';

@NgModule({
  declarations: [
    AppComponent,
    NationComponent,
    RegionComponent,
    UnitComponent,
    CommandComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    HttpClientModule
  ],
  providers: [
    RegionService,
    NationService,
    UnitService,
    CommandService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
