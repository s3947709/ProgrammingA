package Tutorial2_0;

class AppDriver {
    public static void main(String[] args) {
    Student s1 = new Student ("John","9 Wallaby Way",0471,"Blah@student","Bachelor Degree",3);
    System.out.println(s1.toString());

    Employee e1 = new Employee("Bob", "11 Presidency Lane", 0466, "bestemployee@company", "Blackburn", 30.00, "31/05/20");
    System.out.println(e1.toString());
    }
}
