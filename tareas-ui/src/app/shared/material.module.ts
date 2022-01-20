import { NgModule }                                                   from '@angular/core';
import { MatTableModule }                                             from '@angular/material/table';
import { MatSortModule }                                              from '@angular/material/sort';
import { MatDialogModule }                                            from '@angular/material/dialog';
import { MatInputModule }                                             from '@angular/material/input';
import { MatDatepickerModule }                                        from '@angular/material/datepicker';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE }             from '@angular/material/core';
import { MomentDateModule, MatMomentDateModule, MomentDateAdapter }   from '@angular/material-moment-adapter';
import { MatCheckboxModule }                                          from '@angular/material/checkbox';
import { MatButtonModule }                                            from '@angular/material/button';

const MaterialComponents = [
  MatTableModule,
  MatSortModule,
  MatDialogModule,
  MatInputModule,
  MatDatepickerModule,
  MatCheckboxModule,
  MatButtonModule,
  MomentDateModule,
  MatMomentDateModule
];

export const MY_FORMATS = {
  parse: {
      dateInput: 'LL'
  },
  display: {
      dateInput: 'DD-MM-YYYY',
      monthYearLabel: 'YYYY',
      dateA11yLabel: 'LL',
      monthYearA11yLabel: 'YYYY'
  }
};

@NgModule({
  declarations  : [],
  imports       : [MaterialComponents],
  exports       : [MaterialComponents],
  providers     : [
    { provide: MAT_DATE_LOCALE, useValue: 'es-CL', multi: true },
    { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
    { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS }
  ]
})
export class MaterialModule { }
