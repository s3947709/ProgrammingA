package Tutorial2_0;

class Account {
    private String name;
    private int accID;

    static int nextID = 0;
    
    static double minBal = 0;
    
    public Account (String name){
        this.name = name;
        nextID += 1;
        this.accID = nextID;
    }

    public String toString(){
        return "Account User: " + name + "      User ID: " + accID;
    }    
}
