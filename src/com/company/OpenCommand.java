package com.company;

public class OpenCommand extends Command {
    @Override
    public boolean canExecute(String command) {
        return command.contains("open");
    }

    @Override
    public boolean execute(String command) throws InvalidCommandException, InvalidFileException {
        String[] commandParts = command.trim().split("\\s+");
        if(commandParts.length != 2){
            throw new InvalidCommandException("Invalid open parameters!");
        }

        CatalogSingletone.getInstance().open(commandParts[1]);
        return true;
    }
}
