package Tutorial2_0;

class Bank {
    public static void main(String[]args){
        CredAccount c1 = new CredAccount("Bob Credit", -32);
        System.out.println(c1.toString());

        SavAccount s1 = new SavAccount("Bob Savings", 220);
        System.out.println(s1.toString());
    }
}