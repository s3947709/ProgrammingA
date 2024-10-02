package Tutorial2_0;

class Employee extends Person {
    private String office;
    private double salary;
    private String date;

    public Employee (String name, String address, int phNum, String email, String office, double salary, String date){
        super(name, address, phNum, email);
        this.office = office;
        this.salary = salary;
        this.date = date;
    }

    public String toString(){
        return super.toString() + " Office: " + office + " Salary: " + salary + " Date Hired: "  + date;
    }
}
