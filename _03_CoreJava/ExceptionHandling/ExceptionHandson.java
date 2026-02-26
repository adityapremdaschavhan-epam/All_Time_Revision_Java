package ExceptionHandling;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}

public class ExceptionHandson {

    // handling unchecked exception using try catch finally
    public static void handleNullPointerException(){
        try{
            String str = null;
            System.out.println(str.length());
        }
        catch(NullPointerException e){
            System.out.println("catch block has handles the exception-->" + e);
        }
        finally {
            System.out.println("thank catchy for handling  null pointer exception successfully");
        }
    }

    // creating custom exception and handling it
    public static void withdraw(int amount,int balance) throws InsufficientBalanceException{
        if(balance < amount){
            throw new InsufficientBalanceException("amount cannot be withdrawn");
        }
    }


    static void main() {
        handleNullPointerException();


//        try{
//            withdraw(500,300);
//        }
//        catch(InsufficientBalanceException e){
//            System.out.println("errrrrrro--->"+e);
//        }

    }
}
