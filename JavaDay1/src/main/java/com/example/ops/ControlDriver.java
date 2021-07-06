package com.example.ops;

public class ControlDriver {

public static void main(String[] args) {
		
		ControlFlow cf = new ControlFlow();
		
		cf.ifElseIfElseExample(0);
		cf.switchStatement("Swinter");
		cf.ternary(4);
		cf.forLoopExample();
		cf.whileLoopExample();
		cf.doWhileLoopExample(10);
		cf.printEvens();
		cf.shortCircuit();
		cf.preVsPostFix();
	}

}
