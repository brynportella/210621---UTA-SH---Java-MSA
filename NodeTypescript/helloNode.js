//console.log('Hello Node');

//Previsouly I mentioned ES6 gave us modules
//Modules are one of the great features about node
//Modules are essentially a unit of js code that is meant to be reused by exporting and importing

function greeting(name){
    return `Hello my name is ${name}`;
}

//console.log(greeting('Bob'));

//To allow something to be used by another module we need to export
module.exports = greeting;