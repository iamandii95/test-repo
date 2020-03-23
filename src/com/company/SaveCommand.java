package com.company;


public class SaveCommand extends Command {
    @Override
    public boolean canExecute(String command) {
        return command.toLowerCase().contains("save");
    }

    @Override
    public boolean execute(String command) throws InvalidCommandException, InvalidFileException {
        String[] commandParts = command.toLowerCase().split("\\s+");
        if(commandParts.length != 2) {
            throw new InvalidCommandException("Invalid save parameters!");
        }

        CatalogSingletone.getInstance().save(commandParts[1]);
        return true;
    }
}
