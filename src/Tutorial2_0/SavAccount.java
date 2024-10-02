package Tutorial2_0;

class SavAccount extends Account {
    private double savings;


    public SavAccount(String name,double savings){
        super(name);
        if (savings <= minBal){
            this.savings = minBal;
        }
        else {
            this.savings = savings;
        }
    }

    public String toString(){
        return super.toString() + "\nAccount Savings: " + savings;
    }
}
