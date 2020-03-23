package com.company;


public class InvalidFileException extends Exception {

    private String fileName;

    public InvalidFileException(String fileName) {
        this.fileName = fileName;
    }

    @Override()
    public String toString() {
        return "Invalid file name from custom exception: " + this.fileName;
    }
}
