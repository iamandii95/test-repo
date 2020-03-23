package com.company;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Document  implements Serializable {
    private String name;
    private String uniqueId;
    private HashMap<String,String> tag;
    private String path;
    public Document (){
        setName(new String());
        setUniqueId(new String());
        setTag(new HashMap<>());
        setPath(new String());
    };
    public Document(String name1, String uniqueId1,  HashMap<String,String> tag1, String path){
        setName(name1);
        setUniqueId(uniqueId1);
        setTag(tag1);
        setPath(new String());
    }

    public  String getPath() {
        return path;
    }
    public  void setPath(String path1){
        path = path1;
    }

    public void addTag(String nameTag, String valueTag){
        getTag().put(nameTag,valueTag);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public HashMap<String, String> getTag() {
        return tag;
    }

    public void setTag(HashMap<String, String> tag) {
        this.tag = tag;
    }
}
