package com.pcq.ClassCast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random rand = new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() {//随机获得一个类型的Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 随机获得大小为size的Pei数组
     * @param size
     * @return
     */
    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    /**
     * 获得List Pet
     * @param size
     * @return
     */
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> petList = new ArrayList<Pet>();
        Collections.addAll(petList, createArray(size));
        return petList;
    }
}
