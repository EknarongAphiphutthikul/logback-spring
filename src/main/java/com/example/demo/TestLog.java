package com.example.demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@Component
public class TestLog {
	
	private Logger logger = LoggerFactory.getLogger("com.example.demo.TestLog");
	private Logger loggerMDC = LoggerFactory.getLogger("LogTestMDC");
    
	@PostConstruct
	public void testLog() {
		//printInternalState();
		// default level info
		logger.debug("Hello world. Debug");  // not show
		logger.info("Hello world. Info"); // show
		
		// add src/main/resources/logback-spring.xml
		MDC.put("mdc1", "Test1");
		loggerMDC.info("Test MDC1");
		loggerMDC.error("Test MDC1 Error", new Exception("exception!!"));
	}
	
	private void printInternalState() {
		// print internal state
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	}
}
