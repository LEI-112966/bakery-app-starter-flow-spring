package com.vaadin.starter.bakery.ui.utils;

/**
 * Utility class for generating template locations in the Bakery application.
 *
 * @author GitHub Copilot
 */
public class TemplateUtil {

	/**
	 * Generates a location string by combining the base page and entity ID.
	 *
	 * @param basePage the base page path
	 * @param entityId the entity identifier
	 * @return the combined location string
	 */
	public static String generateLocation(String basePage, String entityId) {
		return basePage + (entityId == null || entityId.isEmpty() ? "" : "/" + entityId);
	}
}
