package com.company;

public class LoadCommand extends Command {
    @Override
    public boolean canExecute(String command) {
        return command.toLowerCase().contains("load");
    }

    @Override
    public boolean execute(String command) throws InvalidCommandException, InvalidFileException {
        String[] commandParts = command.trim().split("\\s+");
        if(commandParts.length != 2) {
            throw new InvalidCommandException("Invalid load parameters!");
        }

        CatalogSingletone.setInstance(Catalog.load(commandParts[1]));
        return false;
    }
}
