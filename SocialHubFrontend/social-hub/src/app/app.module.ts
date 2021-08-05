import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NewPostComponent } from './components/new-post/new-post.component';
import { PostsContainerComponent } from './components/posts-container/posts-container.component';
import { PostComponent } from './components/post/post.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginPageComponent } from './components/login-page/login-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    NavbarComponent,
    NewPostComponent,
    PostsContainerComponent,
    PostComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
