package com.example.logging;

import org.apache.log4j.Logger;

public class LogginExample {
	
	final static Logger log = Logger.getLogger(LogginExample.class);
	
	public static void main(String[] args) {
		System.out.println("This is a regular old print statement");
		log.trace("trace message: very fine grained");
		log.debug("this statement would be useful for debugging the application");
		log.info("informational message, use this level of logging");
		log.warn("something bad potentnially could be happening");
		log.error("something went wrong");
		log.fatal("Something extremly wrong happened");
	}
	
}
