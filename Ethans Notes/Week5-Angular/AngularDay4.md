# Testing in Angular

The Angular CLI automatically downloads and installs everything you need to test Angular with the Jasmine framework

Jasmine is a open-source behavior-driven development unit testing framework for Javascript

- It is made by Pivotal Labs
- It works with plain JS, Node.JS, Angular/Typescript, Python, Ruby

Jasmine files are `file.spec.ts`

To create a test in the Jasmine files you create a describe fuction, that describes the test suite, as well as takes a callback function

Syntax for a testsuite in Jasmine looks similar to this:

```javascript
describe('Name/description of test suite', () => {
	it('should do something', () => {
		expect(actualValue).toBe(expectedValue);
		expect(actualValue.toBeTruthy();
		expect(actualValue.toBeFalsy();
		expect(actualValue).toEqual(expectedValue);
		expect(actualValue).not.toBe(notExpectedValue);
	}
});
```

You can also use functions such as:
- beforeEach()
- beforeAll()
- afterEach()
- afterAll()

inside of the describe function to perform some task before or after individual tests

To run you tests you simple run `ng test` and it will launch the Karma test runner

Karma is a test runner for Jasmine tests, like Jasmine it is preinstalled when we create out Angular application with the CLI