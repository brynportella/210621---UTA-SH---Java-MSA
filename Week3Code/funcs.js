let arr = [1, 2, 3, 4, 5, 6];

//Enhanced JS For loops
function forOf() {
    //For of loop is used for arrays or array like objects
    for (num of arr) {
        console.log(num + 10);
    }
}

//This will call our function
forOf();

var obj = { name: 'Bob', age: 23 };
function forIn() {
    //For in loop used for accessing the keys of an object
    for (prop in obj) {
        console.log(obj[prop]);
    }
}

forIn();

//Functions can be directly assigned to variables, known as anonymous functions
let coolFunction = function () {
    console.log('I am anonymous');
};

coolFunction();

//Immediately Invoked
(function () {
    console.log('Immediately invoked!');
})();

//Callback are used everywhere, Array methods .find(), .filter(), .map(), and .reduce() use callback functions to operate on data
//find returns the first element that satisfies the callback function
//This function will find the first element greater than 2
let greaterThan = arr.find(function (n) {
    return n > 2;
});

console.log(greaterThan);

//filter filters objects based on a callback function
let greaterThanFilter = arr.filter(function (n) {
    return n > 3;
});

console.log(greaterThanFilter);

//map takes a callback funtion and returns a new array that is the result of calling the function on each element
let squares = arr.map(function (n) {
    return n * n;
});

console.log(squares);

//Scopes
//Anything out here is global scope
let sc1 = 'I am a global scoped variable';

//Anything inside of a block of code is considered local
function scopes() {
    let sc2 = 'I am functional scope!';
    if (sc2) {
        let sc3 = 'I am block scope!';
    }
}

//Hoisting

hoistEx();

function hoistEx() {
    console.log('I hoisted myself!');
}

//Any variables without let or const will be hoisted out of block scope
function varHoist() {
    if (1 > 0) {
        var hoistMe = 'I got hoisted out of the block of code';
    }
    console.log(hoistMe);
}

varHoist();
