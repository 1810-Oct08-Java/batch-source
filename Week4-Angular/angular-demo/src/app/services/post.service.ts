import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PostService {

  url: string = 'https://jsonplaceholder.typicode.com/posts';

  constructor(private http: HttpClient) {
    console.log("created a service");
   }

  getPosts(): Observable<Post[]> {
    console.log("gettin the posts");
    return this.http.get<Post[]>(this.url);
  }

  getPost(id: number): Promise<Post>{
    console.log("gettin a post");
    return this.http.get<Post>(this.url+"/"+id)
      .toPromise();
  }
}
