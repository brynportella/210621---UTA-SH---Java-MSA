import { Component, OnInit } from '@angular/core';
import { POSTS } from 'src/app/mock-posts';
import {Post} from '../../Post';

@Component({
  selector: 'app-posts-container',
  templateUrl: './posts-container.component.html',
  styleUrls: ['./posts-container.component.css']
})
export class PostsContainerComponent implements OnInit {

  posts: Post[] = POSTS;

  constructor() { }

  ngOnInit(): void {
  }

}
