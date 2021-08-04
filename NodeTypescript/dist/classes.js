"use strict";
//To create a class
class Animal {
    //We can create constructors just like java
    constructor(name, species) {
        this.name = name;
        this.species = species;
    }
    //We can have getters and setters
    get getSpecies() {
        return this.species;
    }
    set setSpecies(sp) {
        this.species = sp;
    }
    //methods
    move(feet) {
        console.log(`The animal ${this.name} moved a total of ${feet} feet`);
    }
}
let an = new Animal("Peri", "Cat");
an.move(5);
an.setSpecies = 'Dog';
console.log(an.getSpecies);
//Inheritance is implented through the use of the extends keyword
class Dog extends Animal {
    bark() {
        console.log("Arf Arf");
    }
}
let d = new Dog('Leia', 'Shipoo');
d.bark();
d.move(60);
//We cannot modify name because it is readonly
//d.name = 'Doug';
/*Access Modifiers
public: this is the default if nothing else is specified
private: cannot be visible outside of the class
protected: only by the class and subclasses
Additional modifers:
readonly: this property must be intialized at declaration or by the constructor
*/
class Access {
    constructor() {
        this._width = 0;
        this._height = 0;
    }
    get area() {
        return this._height * this._width;
    }
    set width(w) {
        this._width = w;
    }
    set height(h) {
        this._height = h;
    }
}
let rect = new Access();
rect.height = 5;
rect.width = 10;
console.log(rect.area);
//We can create abstract classes using the abstract keyword
class Car {
    alarm() {
        console.log("BEEEEEEEEEEEEEEEEEEEEEEEEEEEEEP!");
    }
}
class SportsCar extends Car {
    drive() {
        console.log("Drive fast");
    }
}
let sc = new SportsCar();
sc.drive();
sc.alarm();
let user;
user = { username: 'Doodlebob', password: 'menoy', login: () => { return true; } };
user = { username: 'spongebob', password: 'pinaple', phone: 5554443333, login: () => { return true; } };
console.log(user);
