import { Component, Inject }            from '@angular/core';
import { FormBuilder, FormGroup, Validators }   from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA }        from '@angular/material/dialog';
import { IMap, ITarea }                         from 'src/app/interfaces/tarea.interface';
import { AppService }                           from 'src/app/services/app.service';
import { Constants }                            from 'src/app/utils/constants';
import { environment }                          from 'src/environments/environment';

@Component({
  selector      : 'app-popup-tareas',
  templateUrl   : './popup-tareas.component.html',
  styleUrls     : ['./popup-tareas.component.scss']
})
export class PopupTareasComponent {

  public title          = " Tarea";
  public tareaData!     : ITarea;
  public formSection!   : FormGroup;

  constructor(
    public dialogRef: MatDialogRef<PopupTareasComponent>,
    @Inject(MAT_DIALOG_DATA) public tarea: ITarea,
    private formBuilder: FormBuilder,
    private appService: AppService,
  ) { 
    this.tareaData  = tarea.type === 'Agregar' ? {} as ITarea : tarea;
    this.title      = tarea.type + this.title;
    this.setUpFormSection();
  }

  private setUpFormSection(): void {
    this.formSection = this.formBuilder.group({
      identificador     : [{value:  this.tareaData.identificador ? this.tareaData.identificador : '', disabled: true}],
      descripcion       : [this.tareaData.descripcion   ? this.tareaData.descripcion    : '', [Validators.required, Validators.maxLength(100)]],
      fechaCreacion     : [this.tareaData.fechaCreacion ? this.tareaData.fechaCreacion  : '', [Validators.required]],
      vigente           : [this.tareaData.vigente       ? this.tareaData.vigente        : true],
    });
  }

  public validateForm() {
    if (!this.formSection.invalid) {
      const isDeleted = this.tareaData.type === 'Eliminar';
      this.appService.request$({
        verb      : isDeleted ? 'DELETE' : 'POST',
        url       : environment.URL_LOCALHOST + (isDeleted ? Constants.END_TAREA_DELETE : Constants.END_TAREA_SAVE),
        param     : isDeleted ? { key : 'identificador' , value : this.getValueFormSection("identificador") } : {} as IMap,
        object    : this.fillTarea()
      })?.subscribe({
        next: () => {
          this.appService.toastr.success('Tarea guardada correctamente.');
          this.dialogRef.close();
        },error: () => {
          this.appService.toastr.error('Ocurrio un error al intentar guardar.');
        }
      });
    }
  }

  private setDate(date: Date): Date {

    date.setFullYear(date.getFullYear(), date.getMonth(), (date.getDate() + 1));
    console.log('FECHA:', date);
    
    return date;
  }

  private fillTarea(): ITarea {
    return {
      identificador : this.getValueFormSection("identificador"),
      descripcion   : this.getValueFormSection("descripcion"),
      fechaCreacion : this.getValueFormSection("fechaCreacion"),
      vigente       : this.getValueFormSection("vigente")
    } as ITarea;
  }

  private getValueFormSection(formName: string) {
    return this.formSection.get(formName)?.value;
  }

}
