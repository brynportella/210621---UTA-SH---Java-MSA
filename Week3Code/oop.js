//We can create disembodied functions with arrow notation since es6
//A simple arrow function
let simpleArrow = () => console.log('Hello from an arrow function');

simpleArrow();

//Using a parameter with our arrow function
let paramArrow = (num) => {
    //Use template literals to easily print the num
    console.log(`We were given: ${num}`);
    console.log(`The square of ${num} is ${num * num}`);
    //console.log('We were given: ' + num)
};

paramArrow(10);

//Closures are the old way of acheiving encapsulation
const Book = function (t, a) {
    let title = t;
    let author = a;
    return {
        summary: () => {
            console.log(`${title} written by ${author}`);
        },
    };
};

const book1 = new Book('Hippie', 'Paulo Coelho');
book1.summary();

//The old way of creating inheritance
let animal = {
    eats: true,
    walk: () => {
        alert('Animal Walking');
    },
};

let rabbit = {
    jumps: true,
    __proto__: animal,
};

alert(rabbit.eats);
alert(rabbit.jumps);
rabbit.walk();

//Create a class called animal
class Animal {
    constructor(name) {
        //this refers to the specific animal object
        this.name = name;
    }

    static breathe() {
        console.log('breaths');
    }

    speak() {
        console.log(`Hello my name is ${this.name}`);
    }
}

//Lets inherit the animal class
class Cat extends Animal {
    constructor(name, color) {
        //super will make a call to the parent class constructor
        super(name);
        this.color = color;
    }

    //We are overriding the speak method of the parent
    speak() {
        console.log('Meow');
    }
}

let animal2 = new Animal('Doug');
console.log(animal2);
animal2.speak();
Animal.breathe();
console.log(animal2 instanceof Animal);
console.log(animal2 instanceof Cat);

let cat = new Cat('Mister', 'Gray');
console.log(cat);
cat.speak();
Cat.breathe();
console.log(cat instanceof Animal);
console.log(cat instanceof Cat);

//Finally if we wanted to export the class, you can use the export keyword
//export {Cat};
