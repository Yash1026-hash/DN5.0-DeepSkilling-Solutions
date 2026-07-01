class Person {

    private String name;
    private int age;
    private String city;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
    }

    static class Builder {

        private String name;
        private int age;
        private String city;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

public class Builder {

    public static void main(String[] args) {

        Person person = new Person.Builder()
                .setName("John")
                .setAge(30)
                .setCity("New York")
                .build();

        person.display();
    }
}