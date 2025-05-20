import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']  
})
export class AppComponent {
  jokeCount = 1;
  jokes: string[] = [];
  errorMessage = '';

  constructor(private http: HttpClient) {}

  getJoke() {

    this.errorMessage = '';

    if (this.jokeCount > 10) {
      this.errorMessage = 'This may take too long. The maximum number of jokes allowed at once is 10.';
      return;
    }

    if (this.jokeCount > 1) {
      this.getLocalJoke()
    } else {
      this.getJokeFromService()
    }
  }
  getLocalJoke() {
    this.http
        .get<string[]>(`http://localhost:8080/api/jokes?count=${this.jokeCount}`)
        .subscribe((response: any) => {
           console.log('Joke response:', response);
          this.jokes.push(...response);
        });
  }

  getJokeFromService() {
    this.http
        .get<any>('https://icanhazdadjoke.com/', {
          headers: { Accept: 'application/json' },
        })
        .subscribe((response: { joke: string }) => {
          this.jokes.push(response.joke);
        });
  }
}
