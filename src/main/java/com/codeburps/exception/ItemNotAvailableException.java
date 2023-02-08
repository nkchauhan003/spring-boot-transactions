package com.codeburps.exception;

public class ItemNotAvailableException extends RuntimeException {
    public ItemNotAvailableException(int itemId) {
        super("Item not available: " + itemId);
    }
}
