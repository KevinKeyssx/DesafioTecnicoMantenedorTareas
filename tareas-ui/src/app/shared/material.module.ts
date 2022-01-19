import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';

const MaterialComponents = [
  MatTableModule,
  MatSortModule
];

@NgModule({
  declarations  : [],
  imports       : [MaterialComponents],
  exports       : [MaterialComponents]
})
export class MaterialModule { }
