class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //copy constructor to create the copy of the Dog object
    public Dog(Dog dog) {
        this.name = dog.name;
        this.age = dog.age;
    }
    // getters and setters
}

Dog dog1 = new Dog("Puppy", 4);
Dog dog2 = new Dog("Tom", 5);
Dog dog3 = new Dog("Hen", 3);
Dog dog4 = new Dog("Jen", 7);
List<Dog> dogs = new ArrayList<>();
dogs.add(dog1);
dogs.add(dog2);
dogs.add(dog3);
dogs.add(dog4);

//clone with java 8
List<Dog> clonedList = dogs.stream().map(Dog::new).collect(Collectors.toList());
