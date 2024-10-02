package Tutorial2_0;

class Cat extends Pet {
    private String hair;
    
    public Cat (String name, int age, String sound, String food, String hair){
        super(name,age,sound,food);
        this.hair = hair;
    }

    public String toString(){
        return "\nCAT \n" + super.toString() + " \nHair: " + hair;
    }
}
