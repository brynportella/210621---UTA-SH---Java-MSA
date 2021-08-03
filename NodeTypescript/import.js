let greeting = require('./helloNode');

let oss = require('os');

console.log(greeting('Bob'));
console.log(oss.totalmem());

//npm init creates the package.json, it essentially sets up your project
//npm install or npm i package name will install a package, and place the dependency in your package.json
//npm i -g install a package globally
//npm i -d installs a package as a dev dependency

//Global object is essentially the window object
//Timers such as setTimeout(1000) will now come from the global object

//We can also get information about things like environment variables with node js
//process object to get this info
console.log(process.env.JAVA_HOME);