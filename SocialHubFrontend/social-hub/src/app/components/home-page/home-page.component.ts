import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  hide: boolean = true;

  loadPosts(): void{
    this.hide = !this.hide;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
