import Sms.Message;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner e1=new Scanner(System.in);
        Smsapp s1=new Smsapp();
        Sms sm1=new Sms();
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("W-E-L-C-O-M-E T-O O-U-R M-E-S-S-A-G-I-N-G A-P-P");
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
       while (true) {
        System.out.println("Enter 1 add contact to the app");
        System.out.println("Enter 2 to delete contact");
        System.out.println("Enter 3 to display contacts");
        System.out.println("Enter 4 to send message");
        System.out.println("Enter 5 to delete message");
        System.out.println("Enter 6 to sort messages");
        System.out.println("Enter 7 for displaying messages");
        System.out.println("Enter 8 for checking status of messages");
        System.out.println("Enter 9 for exit");

        int input=e1.nextInt();
        if (input==1) {
         s1.addContact();
        }
        else if(input==2){
          s1.deleteContact();
        }
        else if(input==3){
            s1.displaycontacts();
        }
        else if(input==4){
          s1.sendmsg();
        }
        else if(input==5){
          s1.deleteMsg();
        }
        else if(input==6){
            s1.sortMsg();
        }
        else if(input==7){
           s1.displayMsg();
        }
        else if(input==8){
          s1.checkStatus();
        }
        else if(input==9){
          break;
        }
        
       }

       
       
    }

}
