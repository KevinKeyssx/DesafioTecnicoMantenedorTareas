import { NgModule }                   from '@angular/core';
import { BrowserModule }              from '@angular/platform-browser';

import { AppRoutingModule }           from './app-routing.module';
import { AppComponent }               from './app.component';
import { BrowserAnimationsModule }    from '@angular/platform-browser/animations';
import { MaterialModule }             from './shared/material.module';
import { ToastrModule }               from 'ngx-toastr';
import { TareasComponent }            from './pages/tareas/tareas.component';

@NgModule({
  declarations: [
    AppComponent,
    TareasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ToastrModule.forRoot({
      timeOut             : 8000,
      positionClass       : 'toast-top-right',
      preventDuplicates   : true,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
