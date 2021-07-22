console.log('In index.js');

/*
let posts = [
    {
        username: 'rick',
        content: "Morty and I will be doing space stuff today, don't bother us",
    },
    {
        username: 'morty',
        content: 'I will never be doing space stuff with Rick again!',
    },
    {
        username: 'summer',
        content: 'Grandpa Rick never lets me fo on adventures anymore',
    },
];
*/

//We can grab the div that we want to store the posts in
let container = document.getElementById('post-container');

//console.log(container);

function populatePage(posts) {
    //Use a simple enhanced for of loop
    for (postObj of posts) {
        //Create a new div to store our post object in the html document
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.title}</h2>
                      <p>${postObj.body}</p>`;
        //console.log(post);
        //To add these posts to the page we will use append
        container.append(post);
    }
}

//AJAX Asynchronous Javascript and XML
//We are going to use JSONPLaceholder for our APU

let apiURL = 'https://jsonplaceholder.typicode.com/posts';

//When our document loads, it will call this function immediately, and make a request to grab our posts
//There are 4 steps in creating an AJAX request
/*
(() => {
    //Step one: create the XMLHttpRequest Object
    let xhttp = new XMLHttpRequest();

    //Step two: Set a callback function for readystatechange
    xhttp.onreadystatechange = getData = () => {
        //We check if the readyState is set to 4 meaning the response is ready
        //And we check if our status code is 200 meaning the response was OK
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let response = JSON.parse(xhttp.responseText);
            //console.log(response);
            populatePage(response);
        }
    };

    //Step three: Open the request
    //This will create a get request to the specified URL
    xhttp.open('GET', apiURL);

    //Step four: Send the request
    xhttp.send();
})();
*/

//Refactor our above request with fetch and promises
//Normal fetch request that gets called immediately when the page loads
/*
(() => {
    //To make a fetch request you simply use the fetch()
    fetch(apiURL)
        .then((res) => res.json())
        .then((data) => populatePage(data));
})();

//You can look at the response headers
function responseHeaders() {
    //If you want to see what is in the response header use res.headers
    fetch(apiURL).then((res) => console.log(res.headers));
}

responseHeaders();

function requestHeaders() {
    fetch(apiURL, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then((res) => res.json())
        .then((json) => console.log(json));
}

requestHeaders();

//To send data we would use a POST request
function post() {
    let title = 'this is our title value';
    let body = 'this is our body value';
    let postObj = {
        title,
        body,
        id: 1,
    };

    //To make a post request it is similar to a get, but you must set the method to post in the object of the fetch
    fetch(apiURL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(postObj),
    })
        .then((res) => res.json())
        .then((data) => console.log(data));
}

//Realistically you would have this setup with an event listener
post();

function failedRequest() {
    fetch(apiURL, {
        method: 'GET',
        body: {},
    })
        .then((res) => res.json())
        .then((data) => console.log(data))
        .catch((err) => console.log('There was an error'));
}

failedRequest();
*/

//We will refactor one last time using async/await
(async () => {
    let req = await fetch(apiURL);
    let res = await req.json();
    populatePage(res);
})();

async function post() {
    let title = 'this is our title';
    let body = 'this is our body';
    let postObj = {
        title,
        body,
        id: 1,
    };

    let req = await fetch(apiURL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(postObj),
    });

    let res = await req.json();
    console.log(res);
}

post();

async function failedRequest() {
    try {
        let req = await fetch(apiURL, {
            method: 'GET',
            body: {},
        });
        let res = await req.json();
        console.log(res);
    } catch (e) {
        console.log(e);
    }
}

failedRequest();

//Basic promise syntax
let promise = new Promise(function (resolve, reject) {
    //Add the logic for the executor here
    const x = 2;
    const y = 3;
    if (x >= y) {
        resolve();
    } else {
        reject();
    }
});

//Then if we want to use this promise, we probably want to use those consumer functions
promise
    .then(() => console.log('We resolved'))
    .catch(() => console.log('We rejected'))
    .finally(() => console.log('This should run no matter what we do'));
