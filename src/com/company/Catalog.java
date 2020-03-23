package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import static com.company.Operation.*;

public class Catalog implements Serializable {
    public ArrayList<Document> documents= new ArrayList<Document>();
    public Catalog() {
    }

    public Catalog(ArrayList<Document>docs){

        documents = docs;
    }
    void addDoc( Document doc){

        documents.add(doc);
    }
    void  setDocuments( ArrayList<Document> docs){

        documents = docs;
    }
    public  ArrayList<Document> getDocuments(){
        return documents;
    }

    public void list() {
        for (Document doc : documents) {
            String aboutCurrentDoc = documents.toString();
            System.out.println(aboutCurrentDoc + "\n");
        }
    }
    public void open(String docName) throws InvalidFileException {
        Optional<Document> doc = this.documents.stream()
                .filter(g -> g.getName().equals(docName))
                .findFirst();

        if(documents.isEmpty()) {
            return;
        }

        viewDocument(doc.get().getName());
    }

    public void save(String destination) throws InvalidFileException {
        serializeInDocument(destination, this);
    }

    public static Catalog load(String source) throws InvalidFileException {
        return (Catalog) deserializeFromDocument(source);
    }

    public Document getSpecificDocument(String name){

        for ( Document doc : documents)
        {
            if (doc.getName() == name)
                return doc;
        }
        return new Document() {};
    }
    @Override
    public String toString(){
        String result = new String();
        for (Document doc : documents)
        {
            result = result + doc.getUniqueId() + " " + doc.getName() + " " + doc.getTag();
        }
        return result;
    }

}
