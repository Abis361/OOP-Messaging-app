import java.util.Scanner;

public class Smsapp {
    Sms msgs[][];
    static int counter[];
    String contact[];
    static int contactCounter=0;

    Smsapp(){
        msgs=new Sms[30][50];
        contact=new String[30];
        counter=new int[50];
    }
    Scanner sc1=new Scanner(System.in);


   public void addContact(){
    
    System.out.println("Do you want to add a new contact (y/n)");
    String i1=sc1.nextLine();
    while(i1.equals("y")) {
        System.out.println("Enter Contact number of 13 Digits");
        contact[contactCounter]=sc1.nextLine();
        contactCounter++;
        System.out.println("Do you want to add another number? Press y to add and n for exit");
        i1=sc1.nextLine();
    }
   
   }
    
   public void deleteContact(){
    
        System.out.println("Enter contact number you want to delete");
        String d1=sc1.nextLine();
        if(locatecontact(d1)){
          int contactinfo=getindex(d1);
          for(int i=contactinfo;i<contactCounter-1;i++){
            contact[i]=contact[i+1];  
          }
          contactCounter--;
          System.out.println("Contact has been deleted");
        }
        else{
            System.out.println("Invalid number,Record not found");
        }
   }

   public void displaycontacts(){
    for(int i=0;i<contactCounter;i++){
        System.out.println(contact[i]);
    }
   }
   public void sendmsg(){
    System.out.println("Do you want to send message(y/n)");
    String a1=sc1.nextLine();
    while (a1.equals("y")) {
        System.out.println("Enter receiver number");
    String receiverNo=sc1.nextLine();
    if(locatecontact(receiverNo)){
        int index=getindex(receiverNo);
        System.out.println("Enter messsage content");
        String msgContent=sc1.nextLine();
        int msgId = counter[index] + 1;
                System.out.println("your msg id is  :" + msgId);
                System.out.println("setting  msg status");
                boolean status = false;
                 
                String sender="You";

                msgs[index][counter[index]] = new Sms(sender,receiverNo,msgContent,msgId,status); 
                 counter[index]++;
                System.out.println("Message sent to " + receiverNo + " with ID: " + msgId);
            } else {
                System.out.println("No contact found");
            }
            System.out.println("Do you wanna send another message?");
            a1= sc1.nextLine();
    }
    
        }

        public void checkStatus() {
             System.out.println("write number to check its status whether it is seen or not");
            String number = sc1.nextLine();
            
            if (locatecontact(number)) {
                int numIndex = getindex(number);
                
                boolean allSeen = true;  // Assume all messages are seen initially
                
                for (int i = 0; i < counter[numIndex]; i++) {
                    if (!msgs[numIndex][i].isStatus()) {
                        allSeen = false;  // If any message is not seen, change the flag
                        break;
                    }
                }
                
                if (allSeen) {
                    System.out.println("All messages are seen for " + number);
                } else {
                    System.out.println("Some messages are not seen for " + number);
                }
            } else {
                System.out.println("No contact found");
            }
        }

        public void sortMsg(){
            
            System.out.println("write number to show its sorted msgs");
            String receiverId = sc1.nextLine().trim();
            int contactIndex = getindex(receiverId);
            if (contactIndex==-1) {
                System.out.println("can't find such contact");
                return;
            }
    
           
            if (counter[contactIndex] == 0) {
                System.out.println("No messages found for this number.");
                return;
            }
            for (int i = counter[contactIndex]-1; i >= 0; i--) {
                if (msgs[contactIndex][i] != null)  {
                 
                    System.out.println(msgs[contactIndex][i].getFormattedDateTime()+"-"+msgs[contactIndex][i].getMsgContent());
                }else{
                    System.out.println("Message is not found");
                }
            }
        }
        public void displayMsg() {
            
            boolean msgCheck = false;
            System.out.println("Give receiver number to see your messages");
            String receiverId = sc1.nextLine();
            int contactIndex = getindex(receiverId);
            if (contactIndex==-1) {
                System.out.println("can't find such contact");
                return;
            }
            System.out.println(counter[contactIndex]+" msg for this number");
            for (int i = 0; i < counter[contactIndex]; i++) {
               
                System.out.println(msgs[contactIndex][i].toString());
                System.out.print("\n");
                msgs[contactIndex][i].setStatus(true);
                msgCheck = true;
    
            }
            if (!msgCheck) {
                System.out.println("Sorry! can't find any message for " + receiverId + " id");
            }
        }
        public void deleteMsg() {
           
            System.out.println("write number to delete that one");
            String receiverId = sc1.nextLine();
            int contactIndex = getindex(receiverId);
            boolean dltCheck = false;
            System.out.println("There are "+counter[contactIndex]+"msgs available for this number");
            for (int i = 0; i < counter[contactIndex]; i++) {
              
                System.out.println("Message id " + msgs[contactIndex][i].getMessageId() + "," +"Message:"+ msgs[contactIndex][i].getMsgContent());
            }
            System.out.println("select msg Id to delete");
            int msgtodlt = sc1.nextInt();
    
            for (int i = 0; i < counter[contactIndex]; i++) {
                if (msgs[contactIndex][i].getMessageId() == msgtodlt) {
                    for (int j = i; j < counter[contactIndex] - 1; j++) {
                        msgs[contactIndex][j] = msgs[contactIndex][j + 1];
                    }
                    msgs[contactIndex][counter[contactIndex] - 1] = null;
                    counter[contactIndex]--;
                    dltCheck = true;
                    break;
                }
            }
            if (dltCheck) {
                System.out.println("Message deleted with id " + msgtodlt);
            } else {
                System.out.println("Msgs not found for this id");
            }
    
        }

      
   public boolean locatecontact(String num){
          for(int i=0;i<contactCounter;i++){
          if (contact[i].equals(num)) {
           return true;
          }
        }
          return false;
   }
   public int getindex(String number){
    for(int i=0;i<contactCounter;i++){
        if(contact[i].equals(number)){
            return i;
        }
       
    }
    return -1;
   }

}


