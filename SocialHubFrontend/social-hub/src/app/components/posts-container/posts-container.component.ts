import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Post} from '../../Post';
import { PostService } from '../../services/post.service';

@Component({
  selector: 'app-posts-container',
  templateUrl: './posts-container.component.html',
  styleUrls: ['./posts-container.component.css']
})
export class PostsContainerComponent implements OnInit {

  posts: Observable<Post[]> = new Observable<Post[]>();

  addPost(post: Post): void{
    this.postService.addPost(post);
    this.posts = this.postService.subject;
  }

  constructor(private postService:PostService) { }

  ngOnInit(): void {
    //We will use the ngOnInit lifecycle method to grap the posts as soon as the posts-container component is created
    this.postService.getPosts();
    this.posts = this.postService.subject;
  }

}
