package com.company;

public abstract class Command {
    public abstract boolean canExecute(String command);

    public abstract boolean execute(String command) throws InvalidCommandException, InvalidFileException;
}
