//To create a class
class Animal{
    //We can add some fields
    readonly name: string;
    private species: string;

    //We can create constructors just like java
    constructor(name: string, species:string){
        this.name = name;
        this.species=species;
    }

    //We can have getters and setters
    get getSpecies(): string{
        return this.species;
    }

    set setSpecies(sp: string){
        this.species = sp;
    }

    //methods
    move(feet: number):void{
        console.log(`The animal ${this.name} moved a total of ${feet} feet`);
    }
}

let an = new Animal("Peri", "Cat");
an.move(5);

an.setSpecies = 'Dog';
console.log(an.getSpecies);

//Inheritance is implented through the use of the extends keyword
class Dog extends Animal{
    bark():void{
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

class Access{
    private _width: number = 0;
    private _height: number = 0;

    get area(){
        return this._height*this._width;
    }

    set width(w:number){
        this._width = w;
    }

    set height(h:number){
        this._height = h;
    }
}

let rect = new Access();

rect.height = 5;
rect.width = 10;
console.log(rect.area);

//We can create abstract classes using the abstract keyword
abstract class Car{
    abstract drive(): void;

    alarm():void{
        console.log("BEEEEEEEEEEEEEEEEEEEEEEEEEEEEEP!");
    }
}

class SportsCar extends Car{
    drive():void{
        console.log("Drive fast");
    }
}

let sc = new SportsCar();
sc.drive();
sc.alarm();

//Interfaces allow us to create contacts that other classes/objects can implement, defined using the interface keyword it can include properties an
//and methods, you can create optional properties using the ?
//Interfaces are not transpiled into JS, they are instead only used for type

interface User{
    username:string,
    password:string,
    phone?: number,
    login(): boolean
}

let user: User;

user = {username: 'Doodlebob', password: 'menoy', login: () => {return true}}
user = {username: 'spongebob', password: 'pinaple', phone:5554443333, login: () => {return true}}

console.log(user);