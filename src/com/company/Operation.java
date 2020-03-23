package com.company;

import java.awt.*;
import java.io.*;

public class Operation {
    public Operation(){

    }



    public static void viewDocument(String fileName) throws InvalidFileException {
        try {
            Desktop desktop = null;
            if (!Desktop.isDesktopSupported()) {
                return;
            }

            desktop = Desktop.getDesktop();
            desktop.open(new File(getFullFilePath(fileName)));
        } catch (Exception e) {
            throw new InvalidFileException(fileName);
        }
    }

    public static void saveToDocument(String fileName, String content) throws InvalidFileException {
        try {
            FileOutputStream fileOut = new FileOutputStream(getFullFilePath(fileName));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeUTF(content);
            out.close();

            fileOut.close();
        } catch (Exception e) {
            throw new InvalidFileException(fileName);
        }
    }

    public static void serializeInDocument(String fileName, Object object) throws InvalidFileException {
        try {
            FileOutputStream fileOut = new FileOutputStream(getFullFilePath(fileName));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();

            fileOut.close();
        } catch (Exception e) {
            throw new InvalidFileException(fileName);
        }
    }

    public static Object deserializeFromDocument(String fileName) throws InvalidFileException {
        try {
            FileInputStream fileIn = new FileInputStream(getFullFilePath(fileName));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object deserializedObject = in.readObject();
            in.close();
            fileIn.close();

            return deserializedObject;
        } catch (Exception e) {
            throw new InvalidFileException(fileName);
        }
    }

    private static String getFullFilePath(String fileName) {
        return  fileName;
    }
}