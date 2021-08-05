import { Injectable } from '@angular/core';
import {Post} from '../Post';
import {POSTS} from '../mock-posts';


@Injectable({
  providedIn: 'root'
})
export class PostService {
  constructor() { }

  getPosts():Post[]{
    return POSTS;
  }

  addPost(post: Post): Post[]{
    let postArr: Post[] = POSTS;
    postArr.unshift(post);
    return postArr;
  }
}
