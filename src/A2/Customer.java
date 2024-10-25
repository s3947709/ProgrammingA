package A2;

import java.io.Serializable;

public class Customer implements Serializable{
    private int Custid;
    private String firstName;
    private String lastName;
    private String skillLevel;

    public Customer(int Custid, String firstName, String lastName, String skillLevel) {
        this.Custid = Custid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillLevel = skillLevel;
    }

    public int getCustId() {
        return Custid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return Custid + ": " + firstName + " " + lastName + " (Skill Level: " + skillLevel + ")";
    }
}
