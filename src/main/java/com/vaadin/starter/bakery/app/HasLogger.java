package com.vaadin.starter.bakery.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Feature interface providing logging capability for implementing classes.
 * <p>
 * Classes implementing this interface can obtain a logger instance for their own class.
 * This is useful in serializable environments where static loggers are not suitable.
 * </p>
 *
 * @author GitHub Copilot
 */
public interface HasLogger {

	/**
	 * Returns a logger instance for the implementing class.
	 *
	 * @return Logger for the class
	 */
	default Logger getLogger() {
		return LoggerFactory.getLogger(getClass());
	}
}
