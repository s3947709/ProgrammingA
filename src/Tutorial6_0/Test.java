package Tutorial6_0;

public class Test {
    public static void main(String[]args){
        try{
            int value = 30;
            if (value < 40){
                throw new Exception("value is too small");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Continue after the catch block");
    }
}
