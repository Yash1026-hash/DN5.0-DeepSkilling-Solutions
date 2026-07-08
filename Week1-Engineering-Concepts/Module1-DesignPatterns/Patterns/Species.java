class Animal {
    String name;
    String animalSound;

    Animal(String name, String animalSound) {
        this.name = name;
        this.animalSound = animalSound;
    }
}

class Dog extends Animal {
    Dog(String name, String animalSound) {
        super(name, animalSound);
    }

    void display() {
        System.out.println("Dog name is: " + super.name);
        System.out.println("Dog sound is: " + super.animalSound);
    }
}

class Cat extends Dog {
    Cat(String name, String animalSound) {
        super(name, animalSound);
    }

    void display() {
        System.out.println("Cat name is: " + super.name);
        System.out.println("Cat sound is: " + super.animalSound);
    }
}

public class Species {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "Bark");
        d.display();

        Cat c = new Cat("Milo", "Meow");
        c.display();
    }
}