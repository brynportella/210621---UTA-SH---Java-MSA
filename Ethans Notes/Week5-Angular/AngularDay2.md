# Single Page Applications

Single Page Applications or (SPA's) are webapps that render on a single page in the browser

Aall of our Javascript, HTML, and CSS are loaded in and ready for the browser in one page load

During navigation, the browser never refreshes because you stay on the same page

We will use Angular to create our SPA's

The advantages of SPA's

- Fast and responsive
- Caching capability
- Pleasant user experience across multiple platforms

Disadvantages

- Don't perform well with SEO
- Less secure against Cross-site scripting
- The page may take longer to load initially

# History of Angular

Angular is a Typescript based, open source framework used to develope dynamic web applications

Angular has gone through many changes since it was created by Google in 2010

- It started out as AngularJS
- In 2016 a completely rewritten version was released
    - This prompted the name change from AngularJS to Angular2
- Angular is now commonly known as Angular 2+
- Angular 4 is now the standard, that is what we will use
- After Angular 4, there has been small incremental changes, about every 6 months

## AngularJS vs Angular 4+

AngularJS is a javascript-based open source web framework, that doesn'tsuppoer the features of a server-side programming language, nor dynamic page loading

Angular 4+ is a complete rewrite of Angular JS, with a complete comparison below:

| Angular JS                                                                                         | Angular 4+                                                                                                                       |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| Uses MVC architecture to build the applications.                                                   | Uses component based UI to build the applications.                                                                               |
| AngularJS is written in JavaScript.                                                                | Angular is compatible with the most recent versions of TypeScript that have powerful type checking and object-oriented features. |
| To bind an image/property or an event with AngularJS, you have to remember the right ng directive. | Angular focuses on “( )” for event binding and “[ ]” for property binding.                                                       |
| AngularJS doesn't support mobiles.                                                                 | Angular support mobiles.                                                                                                         |

Angular uses Typescript, and uses several main building block we will discuss this week:
- modules
- components
- templates
- metadata
- data binding
- directives
- services
- dependency injection

# Webpack

Webpack is a powerful static module bundler for Javascript applications that packages all modules in our application into a bundle and serves it to the browser

This means that all of our JS files and dependencies would be in a single file, all our HTML files would be in a single file, and so

This helps speed up the loading of our webpage, because instead of loading up several files, it just loads one

Webpack builds a dependency graph when it proccesses the application. It starts from a lost of modules defined in its config file and recursively builds the dependency grpah that includes every module of our application neds, then packages all of those modules into a small bundle that can be loaded by the browser

# Angular CLI

The Angular CLI is a command-line interface for Angular, that helps us get started with creating an Angular application

- It sets up the project in Typescript, and installs dependencies like Webpack, Karma for testing, and others

To install the Angular CLI use `npm install -g @angular/cli`

To create a new Angular project use `ng new app-name`

To start your application use `ng serve --open`

## Angular File Structure

- e2e holds files for end-to-end tests, and test specific config files
- node_modules holds all of our dependencies
- src folder holds the source code for our application

# @NgModule Decorator

We use the @NgModule decorator to mark the root module/class of our application

NgModule takes metadata and describes how to compile a compents templates how to create an injector at runtime

The Angular CLI creates the AppModule where we use the NgModule for us, it takes the following metadata:

- declarations: a list of components, directives, and pipes which belong to the app
- imports: alist of modules, which are used by the component templates
- providers: a list of service providers the application needs
- boostrap: contains the root component of the application

The steps to starting an Angular application (bootstrapping):

1. the main.ts in an entry poin of an angular application
2. We bootstrap an angular application and pass app.module.ts as an argument. In app.module.s we tell angular to bootstrap the AppComponent
3. Angular analyzes this AppComponent and knows there is an app-root selector defined
4. Angular handles app-root in the index.html file
5. index.html gets loaded on the browser

# Components and @Component decorator

Components are the basic building blocks of our application

The purpose of components is so we can break up our UI and logic into individual pieces, each component has a specific purpose

An Angular application has one root component (AppComponent) which is specified in the bootstrap array under the main ngModule

We declare a component with the @Component Decorator

The @Component decorator needs to be imported from the @angular/core module, and will be used in the ts file of your component

Components can also have associated HTLM, and CSS files to describe how the component should look

Inside of our @Component decorator there are a few properties:

- selector: a css selector that tells angular to crate and insert an instance of this component into a specified element
- templateUrl: the module relative address to the components THL template, or an inline HTML template
- styleUrls: an array of css files or inline css styles

You can use inline templates in the Angular HTML template using double curly braces {{}} to  bind data from our components

You declare these properties inside of the export of the compoent class

The easiest way to create a component is `ng generate component c-name` this will generate all the relevant files for a component