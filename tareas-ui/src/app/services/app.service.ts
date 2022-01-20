import { Injectable }       from '@angular/core';
import { HttpClient }       from '@angular/common/http';
import { ToastrService }    from 'ngx-toastr';
import { IMap, ITarea }           from '../interfaces/tarea.interface';
import { environment }      from 'src/environments/environment';
import { Constants }        from '../utils/constants';
import { BehaviorSubject, map, Observable }  from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private isLoadingTareasData   = new BehaviorSubject<boolean>(false);
  public isLoadingTareasData$   = this.isLoadingTareasData.asObservable();
  private tareas                = [] as ITarea[];

  constructor(
    private http    : HttpClient, 
    public toastr   : ToastrService) { 
  }

  public setTareas(): void {
    this.request$({
      verb  : 'GET',
      url   : environment.URL_LOCALHOST + Constants.END_TAREA_SEARCHALL
    })?.subscribe((response: any) => {
      if (response) {
        console.log('***RESPONSE TAREAS:', response);
        this.tareas = response;
        this.tareas[0].fechaCreacion.format('dd-mm-yyyy');

        this.isLoadingTareasData.next(true);
      }
    });
  }

  public getTareas(): ITarea[] {
    return this.tareas;
  }

  public getTareas$(): Observable<object> | null {
    console.log('consultando tareas');
    return this.request$({
      verb  : 'GET',
      url   : environment.URL_LOCALHOST + Constants.END_TAREA_SEARCHALL
    })!
    .pipe(map((response: any) => {
        this.tareas = response;
        this.isLoadingTareasData.next(true);
        return response;
      })
    );
  }

  public request$(request : { verb: string, url: string, param?: IMap, object?: ITarea }):  Observable<object> | null {
    return {
      'GET'     : this.http.get<object>(request.url + (request.object ? encodeURI(JSON.stringify(request.object)) : '')),
      'POST'    : this.http.post<object>(request.url, request.object),
      'DELETE'  : this.http.delete<object>(request.url + '?' + request.param?.key + '=' + request.param?.value)
    }[request.verb] || null;
  }

}
