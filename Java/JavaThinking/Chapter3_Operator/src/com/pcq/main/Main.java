package com.pcq.main;


import java.util.Random;

import static com.pcq.method.Print.*;

public class Main {

    private static Random random = new Random(47);
    public static void main(String[] args) {
        print("test");
        printLine();
        print(System.nanoTime());
        print(random.nextLong());
        print(random.nextDouble());
        int a = 1;
        int b = 3;
        int c = a * -b;
        print(c);
        printLine();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.name = "spot";
        dog2.name = "scruff";
        dog1.says = "Ruff";
        dog2.says = "Wurf";
        print(dog1.name + ":" + dog1.says);
        print(dog2.name + ":" + dog2.says);
        Dog dog3 = new Dog();
        dog3.name = "spot";
        dog3.says = "Ruff";
        print(dog1 == dog3);
        print(dog1.equals(dog3));
        Random r = new Random();
        print(r.nextBoolean());
        char x = 0xffff;
        print((int)x);
    }
}


class Dog {
    String name;
    String says;

    public boolean equals(Dog dog) {
        if(dog == null) {
            return false;
        } else if(this.name.equals(dog.name) && this.says.equals(dog.says)) {
            return true;
        }
        return false;
    }
}
