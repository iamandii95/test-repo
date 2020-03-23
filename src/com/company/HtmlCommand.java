package com.company;

import java.util.stream.Collectors;

import static com.company.Operation.saveToDocument;

public class HtmlCommand extends Command {
    @Override
    public boolean canExecute(String command) {
        return command.toLowerCase().equals("raport html");
    }

    @Override
    public boolean execute(String command) throws InvalidFileException {
        String htmlReport = CatalogSingletone.getInstance().getDocuments().stream()
                .map(d -> d.toString())
                .collect(Collectors.joining());
        saveToDocument("myhtmlreport.html", htmlReport);

        return false;
    }
}