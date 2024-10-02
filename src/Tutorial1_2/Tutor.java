package Tutorial1_2;

class Tutor {
    private String staffName;
    private String staffID;

    public Tutor(String staffName, String staffID){
        this.staffName = staffName;
        this.staffID = staffID;
    }

    public String toString(){
        return "Name: " + staffName + " ID: " + staffID;
    }
}
