package Tutorial2_0;

class Dog extends Pet {
    private String breed;

    public Dog (String name, int age, String sound, String food, String breed){
        super(name,age,sound,food);
        this.breed = breed;        
    }

    public String toString(){
        return "DOG \n" + super.toString() + "\nBreed: " + breed;
    }
}
