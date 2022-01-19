import { NgModule }                               from '@angular/core';
import { MatTableModule }                         from '@angular/material/table';
import { MatSortModule }                          from '@angular/material/sort';
import { MatDialogModule }                        from '@angular/material/dialog';
import { MatInputModule }                         from '@angular/material/input';
import { MatDatepickerModule }                    from '@angular/material/datepicker';
import { MatNativeDateModule, MAT_DATE_LOCALE }   from '@angular/material/core';
import { MatCheckboxModule }                      from '@angular/material/checkbox';
import { MatButtonModule }                        from '@angular/material/button';

const MaterialComponents = [
  MatTableModule,
  MatSortModule,
  MatDialogModule,
  MatInputModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatCheckboxModule,
  MatButtonModule
];

@NgModule({
  declarations  : [],
  imports       : [MaterialComponents],
  exports       : [MaterialComponents],
  providers     : [
    { provide: MAT_DATE_LOCALE, useValue: 'es-CL', multi: true },
  ]
})
export class MaterialModule { }
