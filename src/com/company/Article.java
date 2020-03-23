package com.company;

import java.io.Serializable;
import java.util.HashMap;

public class Article extends Document implements Serializable {
    public Article(String name, String id, HashMap<String,String > tags, String path){
        super(name,id,tags,path);
    }
    public  String toString(){
        return getName() + " " + getUniqueId() + " " + " " + getTag().get(0);
    }
}
