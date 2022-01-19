import { NgModule }                             from '@angular/core';
import { BrowserModule }                        from '@angular/platform-browser';

import { AppRoutingModule }                     from './app-routing.module';
import { AppComponent }                         from './app.component';
import { BrowserAnimationsModule }              from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule }     from '@angular/forms';
import { MaterialModule }                       from './shared/material.module';
import { ToastrModule }                         from 'ngx-toastr';
import { TareasComponent }                      from './pages/tareas/tareas.component';
import { HttpClientModule }                     from '@angular/common/http';
import { PopupTareasComponent }                 from './pages/popup-tareas/popup-tareas.component';

@NgModule({
  declarations: [
    AppComponent,
    TareasComponent,
    PopupTareasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    ToastrModule.forRoot({
      timeOut             : 6000,
      positionClass       : 'toast-top-right',
      preventDuplicates   : true,
    }),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
