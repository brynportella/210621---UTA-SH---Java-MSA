
//We can create a decorator, it is essentially a function that will run on the constructor
function freeze(constructor: Function){
    console.log('-- Frozen decorator invoked --');
    
    //Prevents the elements from being altered
    //Useful for making a class immutable
    Object.freeze(constructor);
}

//Property Descriptor: a simple JS object associated with each property of the object that contains information about that
//property such as its value or some other metadata
//Create an enumeration function which will essentially hide a / any method of the class from for in loops
function enumerable(value: boolean){
    //When this function is called, it modifies the enumerable propert of the property descriptor
    return function(
        target: any,
        propertyKey: string,
        descriptor: PropertyDescriptor
    ){
        descriptor.enumerable = value;
    };
}

//Property decorators are used to listen to the state changes on a class
function logProperty(target: any, key: string){
    var _val = target[key];
    var getter = function (){
        console.log(`Get: ${key} => ${_val}`);
        return _val;
    }

    var setter = function(newVal: any){
        console.log(`Set: ${key} => ${newVal}`);
        _val = newVal;
    }

    if(delete target[key]){
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}

//Parameter Decorator, this goes on a parameter in some function
function required(target: Object, propertyKey: string | symbol, parameterIndex: number){
    console.log('hey this is required');
}

//Use the @ symbol with the method name to use the decorator
@freeze
class Greeter {
    @logProperty
    name: string;
    constructor(name: string){
        console.log('-- this constructor was invoked --');
        this.name = name;
    }

    //Now we will make this so it doesn't show up in for in loops
    @enumerable(false)
    greet() : void{
        console.log(`Hello ${this.name}`);
    }

    welcome(@required name: string){
        console.log(`Hello ${name}`);
    }
}

let ethan = new Greeter('Ethan');
ethan.name = 'Not Ethan';
ethan.greet();

for(let a in ethan){
    console.log(a);
}

ethan.welcome('Bob');