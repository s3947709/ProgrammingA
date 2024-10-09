package A2;
import java.io.Serializable;

class Customer implements Serializable{
    private int custID;
    private String fname;
    private String lname;
    private String skillevel;
    private static int nextID = 1;

    public Customer (){
        custID = nextID++;
    }

    public Customer (String fname, String lname, String skillevel){
        this.fname = fname;
        this.lname = lname;
        this.skillevel = skillevel;
        custID = nextID++;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getSkillevel(){
        return skillevel;
    }

    public int getCustID(){
        return custID;
    }

    public String toString(){
        return "Customer Details [Customer ID: " + custID + ", First Name: " + fname + ", Last Name: " + lname + ", Skill Level: " + skillevel + "]";
    }
}
