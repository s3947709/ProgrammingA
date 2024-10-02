package Tutorial2_0;

class RunPet {
    public static void main(String[] args){
        Dog d1 = new Dog ("Frank",13,"Woof","dry food","Poodle");
        System.out.println(d1.toString());
        System.out.println(d1.Eat());
        System.out.println(d1.Speak());

        Cat c1 = new Cat("Goldilocks", 5, "Meow","wet food","short");
        System.out.println(c1.toString());
        System.out.println(c1.Speak());
        System.out.println(c1.Eat());
    }
}
