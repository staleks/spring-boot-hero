package com.example.demo.domain.error;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -407647539737101640L;

    public static final String NO_RESOURCE_WITH_ID = "There is no resource with id: %d";

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
