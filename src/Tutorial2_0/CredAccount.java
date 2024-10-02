package Tutorial2_0;

public class CredAccount extends Account {
    private double credit;

    public CredAccount (String name, double credit){
        super(name);
        if (credit <= minBal){
            this.credit = minBal;
        }
        else {
            this.credit = credit;
        }
    }

    public String toString(){
        return super.toString() + "\nYou have " + credit + " credit to be paid";
    }
}
