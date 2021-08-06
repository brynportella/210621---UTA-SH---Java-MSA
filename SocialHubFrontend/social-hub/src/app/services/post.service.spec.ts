import { TestBed, fakeAsync, ComponentFixture, tick } from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PostsContainerComponent } from '../components/posts-container/posts-container.component';
import {Subject} from 'rxjs';
import {Post} from '../Post';

import { PostService } from './post.service';

//We are going to make a Mock PostService class, that fakes making calls to the backend
class MockPostService{
  subject: Subject<Post[]> = new Subject<Post[]>();

  getPosts(){
    return[{id:1, username:'test', content:'test content 1'}, {id:2, username:'test', content:'test content 2'}];
  }

  addPost(post:Post){

  }
}

describe('PostService', () => {
  let component: PostsContainerComponent;
  let fixture: ComponentFixture<PostsContainerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostsContainerComponent],
      imports: [RouterTestingModule, HttpClientTestingModule],
      //The provides is what allows us to use the MockPostService in the test instead of actually making calls to the backend
      providers: [{provide: PostService, useClass: MockPostService}]
    }).compileComponents();
  });

  beforeEach(()=> {
    fixture = TestBed.createComponent(PostsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  })



  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should call the PostService getPosts on init', () => {
    //Get an instance of our PostService
    let service = fixture.debugElement.injector.get(PostService);
    //We will setup a "spy" to watch to see if a specific function gets called
    //We are watching to see if our getPosts function in the service gets called
    let serviceSpy = spyOn(service, 'getPosts').and.callThrough();
    //We call component.ngOnInit to act as the component is being initalized
    component.ngOnInit();
    expect(serviceSpy).toHaveBeenCalled();
  });

  it('should call the add post function in PostService', () => {
    //Get an instance of our PostService
    let service = fixture.debugElement.injector.get(PostService);
    //Setting up a "spy" to watch if the addPost function in the Post service gets called
    //When we call the addPost function in the PostsContainerComponent
    let serviceSpy = spyOn(service, 'addPost').and.callThrough();
    //Just calling the addPost method of the PostsContainerComponent
    component.addPost({id: 1, username: 'test', content:'test content'});
    expect(serviceSpy).toHaveBeenCalled();
  })
});
