package Tutorial2_0;

class Student extends Person{
    private String program;
    private int year;

    public Student (String name, String address, int phNum, String email, String program, int year){
        super(name, address, phNum, email);
        this.program = program;
        this.year = year;
    }

    public String toString(){
        return super.toString() + " Program: " + program + " Year: " + year;
    }
}
