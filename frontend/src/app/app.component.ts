import {Component, inject} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {toSignal} from "@angular/core/rxjs-interop";
import {JsonPipe} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, JsonPipe, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'Supermarket Checkout';

  private readonly http = inject(HttpClient);

  testData = toSignal(this.http.get('http://localhost:8080/api/items'));
}
