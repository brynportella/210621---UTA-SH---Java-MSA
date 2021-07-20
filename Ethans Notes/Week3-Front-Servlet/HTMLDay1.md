# HTML

## What is HTML

Hypertext Markup Language

-   Hyper text refers to the ability to link pages to one another
-   Markup language refers to the fact that it is NOT a programming language, rather it describes how a webpage will look

HTML is the standard for displaying webpages on the internet

HTML uses what are called elements and attributes to create the structure and content of the webpage

## HTML Elements

Elements provide the structure of the HTML document

To create an element in an HTML page you use a tag

-   Tags are enclosed in angled brackets <>
-   Most elements need an opening and closing tag, a closing tag has a back slash in it </>, this is to indicate the end of the element
-   An example of a tag would be a div, which looks like this `<div></div>`
-   Some tags are self closing, and do not require a closing tag at the end

You are also allowed to next elements inside of one another

-   You must correctly close the tags for this to be valid
-   An outer tag cannot be closed before an inner tag

Inline vs block elements

-   Block level elements will render on a new line by default
-   Inline elements will/can sit next to one another on the same line when rendered

Common HTML Elements:

-   `<div>`
    -   This is a block level element, denoting a division of the page, typically used to hold other elements
-   `<p>` (paragraph)
    -   This is a block level element, denotes a paragraph
-   `<span>`
    -   This is an inline element, this allows you to group other inline elements
-   `</br>` (break line)
    -   Self closing, block level element, that adds a new line to the page
-   `</img>` (image)
    -   Self closing, inline element that allows you to add an image
-   `<h1> through <h6>` (headings)
    -   Block level element denoting heading text, h1 is the largest, and h6 is the smallest
-   `<a>` (anchor)
    -   Inline element that is used to create a hyper link

## HTML Attributes

Attributes are key/value pairs that give metadata about the tag that is important for the browser to know

-   These are specified inside of the opening tag of your element
-   Can be thought of as parameters definning the specific tag

There are global attributes that can be applied to literally any element in an HTML page

-   class
-   id
-   hidden
-   lang
-   style
-   title

There are also tag specific attributes

-   `<img>` has src and alt attributes
-   `<a>` has href attribute

## HTML Doctype and root tag

Every HTML document should begin with a special tag known as the DOCTYPE declaration

-   This lets the browser know what kind of document and version is it displatying
-   We just user htlm for HTML 5
    -   `<!DOCTYPE html>`

Every HTML document must also have a root tag `<html></html>`

-   Everything must go between the opening and closing of the root tag

There are two other important tags, that go inside of the root tag

-   `<head>` holds metadata about the website
-   `<body>` holds the actualy structure and content of the page

## HTML Tables

Tables are used in HTML to nicely structure and display data

You use a `<table>` to create a table

You use a `<thead>` to define the current row as a header row

-   You would use `<tr>` to create the actual row
    -   Using `<th>` will create the header columns of the table inside of that row

You can use `<tbody>` to define the body of the table

-   You would again use the `<tr>` to create rows inside of the table
    -   The you would use `<td>` to create the table data/the columns of the table

You can use `<tfoot>` to create a footer for your table

Using these different table elements and css, old websites used to exclusively use tables for their layouts

## HTML Lists

HTML also allows you to display lists of items

There are two types of lists: ordered and unordered

-   Ordered Lists have numbers starting at 1
-   Unordered Lists use bullet points

To create an ordered list you use `<ol>`

To create an unorded list you use `<ul>`

You use the `<li>` tag to add elements to a list

-   Ordered lists nests `<li>` tags inside of opening and closing `<ol>` tags
-   Unordered lists nests `<li>` tags inside of opening and closing `<ul>` tags
-   You can also nest different list types inside of one another

## HTML 5

HTML 5 is the most recent version of the HTML markup language, it introduced many new changes including:

-   The DOCTYPE declaration that we saw above
-   Character encoding metadata in the head of our document
    -   This just tells the browser how to convert the bytes into characters
-   The ability to embed audio and video files
-   The ability to run javascript in the background
-   New Semantic elements

## HTML Semantic Elements

HTML 5 introduced new semantic elemts to give tags descriptions rather than only being for functionality

Tags such as `<div>` `<p>` and `<span>` are non-semantic tags

Tags such as `<table>` are semantic tags that we have already seen previous to HTML 5

HTML 5 introduced these sematic tags:

-   `<section>`
-   `<article>`
-   `<header>`
-   `<footer>`
-   `<nav>`
-   `<aside>`
-   `<figure>`
-   `<figcaption>`
-   `<details>`
-   `<mark>`
-   `<summary>`
-   `<time>`

## HTML5 Audio and Video Tags

HTML5 also implemented the ability for you to embed audio and video onto your webpages

To embed audio you simply use the `<audio>` tag

-   Inside of opening tag, you can also include the attribute `controls` so you can start and stop the audio

Nested inside of the `<audio>` tag you must have the `<source>` to specify the audio source and type

-   To specify the source you use the `src` attribute inside of the source tag
-   To specift the type you use the `type` attribute inside of the source tag

Supported audio types:

| File Format | Media Type |
| ----------- | ---------- |
| MP3         | audio/mpeg |
| OGG         | audio/ogg  |
| WAV         | audio/wav  |

To embed video, you simply use the `<video>`

-   Inside of the opening tag you can include the width and height attributes to specify the width and height of the video
-   Inside of the opening tag you can include `controls` attribute to control the video

Nested inside of the `<video>` you will nedd a `<source>` tag to specify the source of the video and the type of the video

-   To specify the source you use the src attribute
-   To specify the type you use the type atrribute

Supported Video Types:

| Format | MIME-type  |
| ------ | ---------- |
| MP4    | video/mp4  |
| WebM   | video/webm |
| Ogg    | video/ogg  |

| Attribute | Value    | Description                                                   |
| --------- | -------- | ------------------------------------------------------------- |
| src       | URL      | Specifies the URL of the video file                           |
| controls  | controls | Specifies the video controls such as a play/pause button, etc |
| height    | pixels   | Sets the height of the video player                           |
| width     | pixels   | Sets the width of the video player                            |

# Form Elements and Its Attributes

We use forms in HTML to collection data from users of the website

To create a form you would use the for tag `<form>`

The form tag has the following attributes:

-   action: typically the url of the server where you are sending information
-   target: tells the webpage where to load the new page
-   method: specifies which http method to use when submitting

The input tags inside of the form can have the following attributes

-   name: provides a label for that specific input field
-   value: allows you to specify an initial value for that field
-   placeholder: allows you to specify a placeholder text for the form field
-   required: makes it so the user is required to fill in that field
-   min/max: specifies a max or min value for that fied

# Input elements and Input Types

The input element used to get information from the user inside of the form tags, there are many types of form elements including:

-   text: one line text input
-   password: one line text input that where the input is hidden
-   radio: button that only allow one selection per group
-   checkboxes: button that allow multiple selections per group
-   file select: allows you to upload files/select files
-   textarea: a multiline, multi column text field
-   select: allows for users to choose from a drop down
-   reset and submit: do exactly as they sound

To submit a form, you can create an input type of submit, this will automatically submit the form for you, and reload the page

# HTML5 Validation

Before sending form data we want to perform what is called client side form validation

There are two wats to accomplish this

-   Javascript, built-in form validation

In HTML5 there are several ways of validating forms including:

-   required atrribute: forces the user to fill out that field
-   minlength and maxlength: indicate the min or max length of a field
-   type: degine what the type of data should be
-   pattern: defines a pattern (regular expression) that entered data must follow

When data is verified and it satisfies the contraints, they are considered to be valid, and will be given the CSS psuedo class :valid, which can be used to modify the look og the form if the users input is valid

The opposite is also true, if the validation fails, the input will be given the CSS psuedo class :invalid, which can be used to modify the look of the form if the user input is invalid

# Overview of CSS

CSS stands for Cascading Style Sheets

-   It is how we style our webpages

CSS consists of sets of rules that define how elements on a page should look

-   Yout define these using key value pairs

A CSS style rule is composed of selectors and declarations

-   Selector is an HTLM element, or a group HTML elements
-   Declarations are comprised of properties, and values surrounded by curly braces

# Inline, Internal, External Stylesheets

There are three ways in which you can use CSS

-   Inline CSS, this is CSS applied directly to the element in the HTML page
-   Intern/Embedded CSS, this is CSS written inside of `<style>` tag in the head of your document
-   External, this is a completely independent .css file that you import into your html document,
    -   use the `<link rel="stylesheet" href="style.css">` to link you css files

# CSS Box Model

The CSS box model is used to determine how our webpage is rendered by the browser

It makes every element a series of boxes, and CSS allows us to modify each of these boxes

There are four parts of the box model:

-   Margin: Is the outermost retangle
-   Border: Is the area between the Margin and padding
-   Padding: Is the space around the content and border
-   Content: Is the element itself

![Box Model](https://upload.wikimedia.org/wikipedia/commons/e/ed/Box-model.svg)

# CSS Properties

There are numerous properties that we can adjust to style different elements on our webpage

-   border: allows you to change the border shape, size, color, style
-   padding: allows you to change the height and width of the padding
-   margin: allows you to change the height and width margin
-   display: allows you to control the display behavior of the element
-   postion: allows you to move the elements on the page
-   color: allows you to change the color of the element
-   text-align: allows you to align the text inside of the element

# CSS Selectors

Selectors are used to select specific elements or groups of elements to be styled on the webpage

There are several types/ways to select elements:

-   Element selectors: selects by the elements tag (p, h1)
-   Id selector: selects an element by the its id attribute (#id)
-   Class selector: will select a group of elements by the class attribute (.classname)
-   Universal selector: will select all elements on a page (\*)
-   Attribute selector: will select all elements with the specified attribute (\[atribute])
-   Grouping selector: selects multiple elements by their tag, separated by commas
-   Child selector: will select direct children of a specific element (div > p)
-   Descendent selector: will select all of the specified elements nested inside of the parent (div p)
-   General sibling selector: will select sibling elements on the same hierarchy level (div ~ p)
-   Adjacent sibling selector: will select the first sibling of the specified element (div + p)
-   Pseudo class selector: used to specify the state of an element (:visited)
-   Pseudo element selector: used to style parts not specified by the DOM tree (::first-letter)

## Specificity in CSS

In CSS you are allowed to have multiple rules for a single element, in order for the browser to decide which rule to apply there is a style hierarchy which followed known as specificity

This only applies when a single element is targeted by multiple CSS declarations, the order of specificity is as follows:

1. Inline CSS
2. ID selector
3. Class Attribute and Psuedo-Class selectors
4. Element and Psuedo Element Selectors

# Responsive Web Design Overview

Responsive web design is the approach that allows websites to render on all devices, and screensizes by automatically adapting to the screen

This is done through CSS using various settings to serve different style properties based on screen size

-   You use a combination of flexible grids, flex boxes, flexible images, and media queries

## Media Queries

In CSS3 support for responsive web design was added through the use of media queries, it allows for change in the webpage for different devices without any change to the HTML

A media query consists of optional media type, and any number of media feature expressions

-   You can combine multiple queries with the user of logical operators
-   They are case sensitive
-   You use the @media rule to incorporate it with a block of CSS

Media Types:

-   all: used for all media type devices
-   print: used for printers
-   screen: used for any screen
-   speech: used for screen-readers

Media features: describe the specific characteristics of the user agent, output device, or environment, includes

-   grid
-   height
-   width
-   hover
-   and more

Logical Opertators:

-   not
-   and
-   only

## Flex Boxes

Flex box is a one dimensional layout method for arranging elements in rows or columns

-   It is useful for designing flexible, responsive layouts without using float or postions

To use flex box, you simnply need to create a flex container, by setting the css property of display to flex

Any elemeny inside of an element with the display propery of flex, will be considered a flex item. And will be reponsive to the flex box properies

Flex Box properties include:

-   Flex direction: used to change the direction the flex items are displayed (row vs column)
-   Flex wrap: used to define if items should wrap
-   Flex flow: short hand combination of direction and wrap
-   Justify content: used to align items horizontally within the container
-   Align Items: used to align items vertically in the container

Flex Item properties:

-   order
-   flex-grow
-   flex-shrink
-   flex-basis
-   flex-property: shorthand for grow, shrink, and basis
-   align-self

## Import fonts in CSS

You can import fonts in CSS with the @font-face rule

-   Inside you have properties that describe:
    -   The font family
    -   The font fetch
    -   The font weight
    -   The font stretch
    -   The font style
    -   The font source

## CSS animations

You can create animations using CSS and @keyframes

With the @keyframe rule you can define different stages of an animation, and set different properties at each stage

## CSS Transitions

Transitions allow you to define the changes for HTML elements, the specific time intervals, the speed of acceleration, and much more

You use the transition property to describe the transition effect

# Bootstrap

Bootstrap is an open source framework and mobile first approach for developing reponsive websites

It allows you to quickly create responsive websites that support HTML5 and CSS3

You can get started with bootstrap by going to their website

https://getbootstrap.com/docs/5.0/getting-started/introduction/

Bootstrap follows a grid system made up of a series of containers, rows, and columns to layour and align containers

Containers are the basic elements that are used to wrap content on the website

Rows are horizontal slices of the screen

Columns are verical slices of the scree, you can have at most 12 columns in a single row

To make use of these, and many other components, you simply have to include the specified classes on the elements

# UI Design Basics

There are a few things to consider when designing your webpages

-   Color can influence the mood, or emotion a user feels when they look at your page
-   Contrast: you want to be able to easily determine, and read the different parts of your page
-   Alignment: try to keep a consistent alignment throughout the webpage
-   Whitespace: use white space to your advantage, you don't want all of your elements crammed
-   Scale: use scale to emphasize important titles, or text, but try not to make everything huge, or too small
-   Typography: try to stick with a professional, appropriate font, google is a good source of fonts
