"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
//We can create a decorator, it is essentially a function that will run on the constructor
function freeze(constructor) {
    console.log('-- Frozen decorator invoked --');
    //Prevents the elements from being altered
    //Useful for making a class immutable
    Object.freeze(constructor);
}
//Property Descriptor: a simple JS object associated with each property of the object that contains information about that
//property such as its value or some other metadata
//Create an enumeration function which will essentially hide a / any method of the class from for in loops
function enumerable(value) {
    //When this function is called, it modifies the enumerable propert of the property descriptor
    return function (target, propertyKey, descriptor) {
        descriptor.enumerable = value;
    };
}
//Property decorators are used to listen to the state changes on a class
function logProperty(target, key) {
    var _val = target[key];
    var getter = function () {
        console.log(`Get: ${key} => ${_val}`);
        return _val;
    };
    var setter = function (newVal) {
        console.log(`Set: ${key} => ${newVal}`);
        _val = newVal;
    };
    if (delete target[key]) {
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}
//Parameter Decorator, this goes on a parameter in some function
function required(target, propertyKey, parameterIndex) {
    console.log('hey this is required');
}
//Use the @ symbol with the method name to use the decorator
let Greeter = class Greeter {
    constructor(name) {
        console.log('-- this constructor was invoked --');
        this.name = name;
    }
    //Now we will make this so it doesn't show up in for in loops
    greet() {
        console.log(`Hello ${this.name}`);
    }
    welcome(name) {
        console.log(`Hello ${name}`);
    }
};
__decorate([
    logProperty,
    __metadata("design:type", String)
], Greeter.prototype, "name", void 0);
__decorate([
    enumerable(false),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", void 0)
], Greeter.prototype, "greet", null);
__decorate([
    __param(0, required),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", void 0)
], Greeter.prototype, "welcome", null);
Greeter = __decorate([
    freeze,
    __metadata("design:paramtypes", [String])
], Greeter);
let ethan = new Greeter('Ethan');
ethan.name = 'Not Ethan';
ethan.greet();
for (let a in ethan) {
    console.log(a);
}
ethan.welcome('Bob');
