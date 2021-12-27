package com.example.demo;

import java.util.concurrent.TimeUnit;

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
	private Logger loggerMDC = LoggerFactory.getLogger("ANYID-PROFILE-DATA");
    
	@PostConstruct
	public void testLog() {
		//printInternalState();
		// default level info
		logger.debug("Hello world. Debug");  // not show
		logger.info("Hello world. Info"); // show
		logger.warn("Hello word. warn"); //show
		
		// add src/main/resources/logback-spring.xml
		MDC.put("TXN_REF_ID", "Test1");
		for (int i = 0; i < 10; i++) {
			loggerMDC.info("Test MDC1");
			loggerMDC.error("Test MDC1 Error", new Exception("exception!!"));
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void printInternalState() {
		// print internal state
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);
	}
}
