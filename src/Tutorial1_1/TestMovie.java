package Tutorial1_1;

public class TestMovie {
    public static void main(String[] args){
        Movie m1 = new Movie ("Catch 22" , "Unknown" , 2020 , 4);
        Movie m2 = new Movie ("Cars" , "Lightning" , 2003 , 5);
        System.out.println(m1);
        System.out.println(m2);

        m1.setRating(10);
        System.out.println(m1);
    }
}
