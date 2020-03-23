package com.company;

public class InvalidCommandException extends Exception {
    private String command;

    public InvalidCommandException(String command) {
        this.command = command;
    }


    @Override()
    public String toString(){
        return "Invalid command " + this.command;
    }
}
