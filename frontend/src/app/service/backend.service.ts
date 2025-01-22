import {HttpClient} from "@angular/common/http";
import {inject, Signal} from "@angular/core";
import {toSignal} from "@angular/core/rxjs-interop";

export class BackendService {
  private http = inject(HttpClient);

  private readonly BASE_URL = 'http://localhost:8080/api/';

  post<T>(url: string, body: any): Signal<T | undefined> {
    return toSignal(this.http.post<T>(this.BASE_URL + url, body));
  }

  get<T>(url: string): Signal<T | undefined> {
    return toSignal(this.http.get<T>(this.BASE_URL + url));
  }

  delete<T>(url: string): Signal<T | undefined> {
    return toSignal(this.http.delete<T>(this.BASE_URL + url));
  }
}
