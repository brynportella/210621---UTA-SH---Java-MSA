//Single line comment

/*
    Multi-line comment
*/

//Javascript is loosely typed, so you can change the variable to any type that you want
//a number
var a = 100;
console.log(a);
//a null
a = null;
console.log(a);
//a undefined
a = undefined;
console.log(a);
//a string
a = 'Johnson';

//To print something in JS use console.log
console.log(a);

//You can create string with either single quotes or double quotes, this is useful if you want one of the quote types in your string
var name = 'Johnson';

//Double quotes
var b = 'Hello';

//Single quotes inside of a string
var c = "Let's have a cup of coffee, Richard style #000";

//Double quotes inside of a string
var d = 'He said "Hello" and left';

console.log(d);

//Numbers
//Integers
var n1 = 21;

//Floating points
var n2 = 15.5;

//exponential notation
var n3 = 1.5e-4;
var n4 = 1.4e4;

//What happens
var n5 = -6 / 0;

//If you divide by 0, you will get infinity
console.log(n5);

//There is also a number called bigInt, which store numbers larger than 2^53
var bigInt = 1234567890123456789012345678901234567890n; //The n at th end denotes that it is a big int

// Booleans which can be true or false
var f = false;
var t = true;

//Objects
var obj = {
    name: 'John',
    age: 30,
};

//Access values of the object in two ways
//dot notation
console.log(obj.name);
console.log(obj['age']);

//You can also create a new object with the new keyword
var obj2 = new Object();
//Then assign values using dot nation
obj2.name = 'Bob';
//We can also assign values using bracket notation
obj2['age'] = 25;

console.log(obj2.name, obj2.age);

//Arrays
//You can create arrays by predefining its indexes
var arr1 = ['Bob', 'Shirley', 'Tom'];

//You can also use the new keyword
var arr2 = new Array(1, 2, 3, 4, 5);

//You can mix and match datatypes in arrays
var arr3 = ['bob', false, 23, { name: 'bob' }];

//You can find the amount of items in an array with .length
console.log(arr3.length);

//You can also access the elements with the indexes
console.log(arr3[0]);

//You can use bracket notation to change the value of a given index
arr3[1] = true;
console.log(arr3[1]);

//You can add new elements using the index
arr3[4] = 'New element';
console.log(arr3);

//Another way to add elements is the .push() method, adds to the end of the array
arr3.push(54);
console.log(arr3);

//We can remove elements with splice, pop, or split
//Pop will remove the index at the very end of the array
arr3.pop();
console.log(arr3);

//We can remove the first element with shift()
arr3.shift();
console.log(arr3);

//Dates
//Use new Date() to create a new date
var d1 = new Date();
console.log(d1);

//There are multiple ways of creating Dates in which you feed the constructor a parameter
//It can take in a milliseconds since EPOCH
var d2 = new Date(1622659765);
//It can take in a date string
var d3 = new Date('20 July 2021');
//It can also take in a year, date, day, hour, minute, second, milisecond
var d4 = new Date(2021, 7, 20, 3, 01, 0, 0);

//typeof returns a string describing the current type of the variable
console.log(typeof 'this is a string');
console.log(typeof 34);
console.log(typeof true);
var ud;
console.log(typeof ud);
