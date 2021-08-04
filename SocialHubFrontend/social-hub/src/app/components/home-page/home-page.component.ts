import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  post1 = {
    id: 1,
    user: 'Rick Sanchez',
    content: 'Morty and I just did some sick space stuff',
    likes: 1
  };

  post2 = {
    id: 2,
    user: 'Summer Smith',
    content: 'Are we going to forget the time grandpa turned snuffles into the leader of an army of dogs',
    likes: 2
  };

  post3 = {
    id: 3,
    user: 'Morty Smith',
    content: 'I am never going on another adventure with Rick again!',
    likes: 1
  };

  post4 = {
    id: 4,
    user: 'Beth Smith',
    content: 'I am so happy to have my dad back in my life',
    likes: 1
  };

  posts = [this.post1, this.post2, this.post3, this.post4];

  hide: boolean = true;

  loadPosts(): void{
    this.hide = !this.hide;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
