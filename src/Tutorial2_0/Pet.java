package Tutorial2_0;

class Pet {
    private String name;
    private int age;
    private String sound;
    private String food;
    
    public Pet (String name, int age, String sound, String food){
        this.name = name;
        this.age = age;
        this.sound = sound;
        this.food = food;
    }

    public String toString(){
        return "Name: " + name + "\nAge: " + age;
    }

    public String Speak(){
        return name + " makes the sound " + sound;
    }

    public String Eat(){
        return name + " likes to eats the food " + food;
    }
}
