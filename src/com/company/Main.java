package com.company;
import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.w3c.dom.html.HTMLCollection;
import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import static com.company.Operation.*;

public class Main {

    public static void main(String[] args) throws InvalidFileException, InvalidCommandException {

        final String filepath = "D:\\Facultate\\Programare Avansata(JAVA)\\lab5";
        HashMap<String,String> tags = new HashMap<String,String>();
        tags.put("numberOfPages","222");

        Document firstDocument = new Book("Women","2",tags,filepath) ;
        Document secondDocument = new Book("Men","2",tags,filepath) ;
        Document thirdDocument = new Book("Wo","2",tags,filepath) ;
        firstDocument.setPath(filepath);
        secondDocument.setPath(filepath);
        thirdDocument.setPath(filepath);
        Catalog catalog = new Catalog();
        catalog.addDoc(firstDocument);
        catalog.addDoc(secondDocument);
        catalog.addDoc(thirdDocument);
        saveToDocument("Men","NewContent");
        System.out.println(catalog.getSpecificDocument("Women").getName());
        saveToDocument(catalog.getSpecificDocument("Women").getName(),"Some new content");
       // viewDocument(catalog.getSpecificDocument("Men").getName());
      //  viewDocument(catalog.getSpecificDocument("Women").getName());
        serializeInDocument(catalog.getSpecificDocument("Wo").toString(),thirdDocument);
        serializeInDocument(catalog.getSpecificDocument("Women").toString(),secondDocument);

        LoadCommand load = new LoadCommand();
        SaveCommand save = new SaveCommand();
        OpenCommand open = new OpenCommand();

        if( open.canExecute("open Men") == true)
        {
            open.execute("open Men");
        }

        if( save.canExecute("save Women"))
        {
            save.execute("save Women");
        }

       // if( load.canExecute("load Wo"))
       // { load.execute("load Wo");
       // }
        HtmlCommand htmlCommand = new HtmlCommand();
       if(htmlCommand.canExecute("raport html"))
       {
          htmlCommand.execute("raport html");
       }
    }
}