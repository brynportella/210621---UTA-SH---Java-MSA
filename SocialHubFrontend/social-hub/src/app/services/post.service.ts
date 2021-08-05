import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable, throwError, Subject } from 'rxjs';
import {catchError} from 'rxjs/operators';
import { UserService } from './user.service';
import {Post} from '../Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  posts: Post[] = [];
  subject: Subject<Post[]> = new Subject<Post[]>();
  constructor(private http: HttpClient, private userService:UserService) { }

  getPosts(){
    this.http.get<Post[]>('http://localhost:8080/SocialHubWeek4/api/posts')
    .pipe(
      catchError((e)=> {
        return throwError(e);
      }))
      .subscribe(
        (data) => {
          this.posts = data;
          this.subject.next(this.posts);
        }
      )
  }

  addPost(post: Post){
    let obj = {
      userId: this.userService.user.id,
      content: post.content
    }

    this.http.post('http://localhost:8080/SocialHubWeek4/api/posts', JSON.stringify(obj))
    .pipe(
      catchError((e)=>{
        return throwError(e);
      }))
      .subscribe(
        (data) => {
          console.log(data);
          this.posts.unshift(post);
          this.subject.next(this.posts);
        }
      )
  }
}
