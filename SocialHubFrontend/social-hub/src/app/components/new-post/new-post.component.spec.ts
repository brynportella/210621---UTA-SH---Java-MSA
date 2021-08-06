import { ComponentFixture, TestBed, fakeAsync, tick} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import{FormsModule} from '@angular/forms';
import {By} from '@angular/platform-browser';

import { NewPostComponent } from './new-post.component';

describe('NewPostComponent', () => {
  let component: NewPostComponent;
  let fixture: ComponentFixture<NewPostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPostComponent ],
      imports: [RouterTestingModule, HttpClientTestingModule, FormsModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should change the value of error if there is no content', () => {
    //Error should only occur on submit if there is no content
    expect(component.error.valueOf()).toBeFalsy();
    component.onSubmit();
    fixture.detectChanges();
    expect(component.error.valueOf()).toBeTruthy();
  });

  it('should update the value of content when typed in', fakeAsync(()=> {
    const input = fixture.debugElement.query(By.css('textarea')).nativeElement;
    fixture.detectChanges();
    tick();
    console.log(input);
    input.value = 'Test';
    input.dispatchEvent(new Event('input'));
    tick();
    expect(component.content).toBe('Test');
  }));

  it('should call the service method when submitted', fakeAsync(() => {
    //Getting the input element
    const input = fixture.debugElement.query(By.css('textarea')).nativeElement;
    //Checking for any changes on the component
    fixture.detectChanges();
    //Trying to force the component to update if something hasnt been detected
    tick();
    //Making sure we have the correct element selected
    console.log(input);
    //Manually setting the components content variable to not be empty since the event on the text area is refusing to work
    component.content = 'Test';
    //Look for changes on the component again
    fixture.detectChanges();
    //Forcing those changes to take place
    tick();
    //Set up a "Spy" to watch our components onAddPost event emmitter
    spyOn(component.onAddPost, 'emit');
    //Manually submit the new post
    component.onSubmit();
    //Detect changes to the component gain
    fixture.detectChanges();
    //Make sure our onAddPost emitter actually emitted a new post on the form submission
    expect(component.onAddPost.emit).toHaveBeenCalled();
  }));
});
