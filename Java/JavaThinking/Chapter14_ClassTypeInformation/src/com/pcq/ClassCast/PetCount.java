package com.pcq.ClassCast;

import java.util.HashMap;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null) {
                put(type, 1);
            } else {
              put(type, quantity + 1);
            }
        }

        public static void main(String[] args) {
            countPets(new ForNameCreator());
        }
        public static void countPets(PetCreator creator) {
            PetCounter petCounter = new PetCounter();
            for(Pet pet : creator.createArray(20)) {
                System.out.println(pet.getClass().getSimpleName() + "");
                if(pet instanceof Pet)
                    petCounter.count("Pet");
                if(pet instanceof Dog)
                    petCounter.count("Dog");
                if(pet instanceof Mutt)
                    petCounter.count("Mutt");
                if(pet instanceof Pug)
                    petCounter.count("Pug");
                if(pet instanceof Cat)
                    petCounter.count("Cat");
                if(pet instanceof Manx)
                    petCounter.count("Manx");
                if(pet instanceof EgyptianMau)
                    petCounter.count("EgyptianMau");
                if(pet instanceof Cymric)
                    petCounter.count("Cymric");
                if(pet instanceof Rodent)
                    petCounter.count("Rodent");
                if(pet instanceof Rat)
                    petCounter.count("Rat");
                if(pet instanceof Mouse)
                    petCounter.count("Mouse");
                if(pet instanceof Hamster)
                    petCounter.count("Hamster");
            }
            System.out.println(petCounter);
        }
    }
}
