package Tutorial2_0;

class Person {
    private String name;
    private String address;
    private int phNum;
    private String email;

    public Person (String name, String address, int phNum, String email){
        this.name = name;
        this.address = address;
        this.phNum = phNum;
        this.email = email;
    }

    public String toString(){
        return "Name: " + name + " Address: " + address + " Phone Number: " + phNum + " Email: " + email;
    }
}
