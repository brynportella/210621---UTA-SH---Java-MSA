function printPressed(e) {
    console.log(`Key pressed in username field: ${e.key}`);
}

//We can also register an event listener by using addEventListener()
let passwordField = document.getElementsByName('password')[0];

console.log(passwordField);

//This is how we register an event with addEventListener
passwordField.addEventListener('keydown', passwordPress);

function passwordPress(e) {
    console.log(`Key pressed in username field: ${e.key}`);
}

//Lets select the form element
let login = document.getElementById('login');

console.log(login);

//Register an event listener for the submit event that the form emits
login.addEventListener('submit', submitForm);

function submitForm(e) {
    e.preventDefault();
    console.log('The login form was submitted');
    console.log(
        `The username was ${document.getElementById('username').value}`
    );
    console.log(
        `The password was ${document.getElementById('password').value}`
    );

    //We can reset the form, this is useful if the user input incorrect information, and you dont navigate
    login.reset();
}
