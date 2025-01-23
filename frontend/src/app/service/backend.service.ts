import {HttpClient} from "@angular/common/http";
import {inject} from "@angular/core";

export class BackendService {
  private http = inject(HttpClient);

  private readonly BASE_URL = 'http://localhost:8080/api/';

  post<T>(url: string, body?: any) {
    return this.http.post<T>(this.BASE_URL + url, body);
  }

  put<T>(url: string, body?: any) {
    return this.http.put<T>(this.BASE_URL + url, body);
  }

  get<T>(url: string) {
    return this.http.get<T>(this.BASE_URL + url);
  }

  delete<T>(url: string) {
    return this.http.delete<T>(this.BASE_URL + url);
  }
}
