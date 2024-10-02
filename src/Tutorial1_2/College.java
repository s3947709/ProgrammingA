package Tutorial1_2;

class College {
    public static void main(String[] args){
        Tutor t1 = new Tutor ("John","194629f");

        Course c1 = new Course ("COSC2095","Programming A", 20);
        c1.setTutor(t1);

        Course c2 = new Course ("COSC2125", "Database", 15);
        c2.setTutor(t1);

        System.out.println(c1);
        System.out.println(c2);

    }    
}
