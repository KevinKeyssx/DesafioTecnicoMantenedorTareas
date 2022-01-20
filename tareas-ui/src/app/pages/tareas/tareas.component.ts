import { Component, ViewChild }     from '@angular/core';
import { MatTableDataSource }               from '@angular/material/table';
import { MatSort }                          from '@angular/material/sort';
import { ITarea }                           from 'src/app/interfaces/tarea.interface';
import { AppService }                       from 'src/app/services/app.service';
import { MatDialog }                        from '@angular/material/dialog';
import { PopupTareasComponent }             from '../popup-tareas/popup-tareas.component';

@Component({
  selector        : 'app-tareas',
  templateUrl     : './tareas.component.html',
  styleUrls       : ['./tareas.component.scss']
})
export class TareasComponent {

  @ViewChild(MatSort, { static: false }) set content(sort: MatSort) {
    this.dataSource.sort = sort;
    console.log('DATA:', sort)
    this.dataSource.sortingDataAccessor = (data, sortHeaderId) => {
      // if (!data[sortHeaderId]) {
      //   return this.content.direction === "asc" ? "3" : "1";
      // }
      // return "2" + data[sortHeaderId].toLocaleLowerCase();


      console.log('DATA:', data);
      console.log('sortHeaderId:', sortHeaderId);
      
      return sortHeaderId;
    };
  }

  public tareaBuilder = {} as ITarea;

  public dataSource: MatTableDataSource<ITarea> = new MatTableDataSource();
  public displayedColumns   = ['Identificador', 'Descripción', 'Fecha creación', 'Vigente'];
  public displayedData      = ['identificador', 'descripcion', 'fechaCreacion', 'vigente'];
  private displayedButtons  = ['Editar', 'Eliminar'];

  constructor(
      private appService: AppService,
      public dialog: MatDialog,
    ) {
    this.displayedColumns.push(...this.displayedButtons);
    this.displayedData.push(...this.displayedButtons);
    this.appService.isLoadingTareasData$.subscribe(isLoad => {
      if (isLoad) {
        this.setTableDataSource();
      }
    });
  }

  private setTableDataSource(): void {
    this.dataSource = new MatTableDataSource(this.appService.getTareas());
  }

  public isButton(value: string): boolean {
    let aux = false;
    this.displayedButtons.forEach(element => {
      if (element === value) {
        aux = true;
      }
    });
    return aux;
  }

  public getIcon(type: string): string {
    return {
      'Editar'      : "https://img.icons8.com/color/48/000000/edit--v2.png", 
      'Eliminar'    : "https://img.icons8.com/color/48/000000/delete-forever.png"
    }[type] || '';
  }

  public openPopUp(row: ITarea, element: string): void {
    row.type = element;
    const dialog = this.dialog.open(PopupTareasComponent, { data: row }).afterClosed().subscribe(() => {
      this.refreshTable();
      dialog.unsubscribe();
    });
  }

  private refreshTable(): void {
    this.appService.getTareas$()!.subscribe(() => {
      complete: () => this.setTableDataSource()
    })
  }

}
