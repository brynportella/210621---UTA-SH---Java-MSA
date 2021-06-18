# Instructions
Create a new Java Project named "UnitConverter"

In the UnitConverter project, create a package named "main"

Inside the main package, create a class named Converter, which has a main(String[]) method.

Inside this main(String[]) method, your code should follow this pattern:

Set up a loop that will continue to allow a user to convert between different units as long as the user doesn't choose to quit. 

Using System.out.println(), print a menu with numbered options. For example (please feel free to choose your own conversions):

Please select an option:
1. Cups to Teaspoons
2. Miles to Kilometers
3. US Gallons to Imperial Gallons
4. Quit

3. Use a Scanner object to collect the user's menuSelection
switch on the user's menu selection, and then collect the user's quanity of the first unit and perform the calculation to convert the value to the second unit. 

Print the result of the conversion. 
And that's basically it! But from here, there are a lot of improvements you could make...

Break the input collection to a separate methodBreak each unit conversion to a separate method
```
public double convertCelsiusToFarenheit(double qty) { ... }
```

Instead of the user selecting their conversion directly from the first menu, have two layers of menus:
- Volume conversions
    -  Teaspoons to Tablespoons
    - Teaspoons to Cups
    -    ...
- Distance conversions
    -    Feet to Meters
    -    Miles to Kilometers
        ...
    ...
    - Quit

Create a **PUBLIC** repository on GitHub.com and push your project there. 
