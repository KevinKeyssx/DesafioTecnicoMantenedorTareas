import { Injectable }       from '@angular/core';
import { HttpClient }       from '@angular/common/http';
import { ToastrService }    from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(
    private http    : HttpClient, 
    public toastr   : ToastrService) { }

  public request$(request : { verb: string, url: string, object: any }) {
    return {
      'GET'     : this.http.get<object>(request.url + encodeURI(JSON.stringify(request.object))),
      'POST'    : this.http.post<object>(request.url, request.object),
      'DELETE'  : this.http.delete<object>(request.url, request.object)
    }[request.verb] || null;
  }

}
