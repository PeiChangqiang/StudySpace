package com.pcq.ClassCast;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static ArrayList<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames = {
      "com.pcq.ClassCast.Mutt",
      "com.pcq.ClassCast.Pug",
      "com.pcq.ClassCast.EgyptianMau",
      "com.pcq.ClassCast.Manx",
      "com.pcq.ClassCast.Cymric",
      "com.pcq.ClassCast.Rat",
      "com.pcq.ClassCast.Mouse",
      "com.pcq.ClassCast.Hamster"
    };

    private static void load() {
        for(String typeName : typeNames) {
            try {
                types.add((Class<? extends Pet>) Class.forName(typeName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {load();}
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
