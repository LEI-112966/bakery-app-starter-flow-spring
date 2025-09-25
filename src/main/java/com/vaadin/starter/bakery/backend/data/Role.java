package com.vaadin.starter.bakery.backend.data;

/**
 * Defines user roles for the bakery application.
 * <p>
 * Roles determine access permissions for different views and features.
 * </p>
 */
public class Role {
    /**
     * Role for barista users.
     */
    public static final String BARISTA = "barista";
    /**
     * Role for baker users.
     */
    public static final String BAKER = "baker";
    /**
     * Role for admin users. This role implicitly allows access to all views.
     */
    public static final String ADMIN = "admin";

    /**
     * Private constructor to prevent instantiation. This class contains only static members.
     */
    private Role() {
        // Static methods and fields only
    }

    /**
     * Returns all defined roles in the application.
     *
     * @return an array of all role names
     */
    public static String[] getAllRoles() {
        return new String[] { BARISTA, BAKER, ADMIN };
    }

}
