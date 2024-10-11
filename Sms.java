import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.Scanner;

public class Sms {

    private String sender;
    private String receiverNo;
    private String msgContent;
    private int messageId;
    private boolean status;
    private LocalDateTime dateTime;

    



    Sms(String sender, String receiverNo, String msgContent,int messageId,boolean status) {
        
        this.sender = sender;
        this.receiverNo = receiverNo;
        this.msgContent = msgContent;
        this.messageId = messageId;
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }
    Sms(){
        
    }
    //public void getinput(){
    //Scanner myobj=new Scanner(System.in);
        //System.out.println("Enter sender no:");
        //String sndrno=myobj.nextLine();
       // System.out.println("Sender number is:"+sndrno);

   // }

    

    public void setStatus(boolean status){
        this.status = status;
    }
    public String getSenderNo() {
        return sender;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); 
        return dateTime.format(myFormat);
    }

    @Override
    public String toString(){
        return "Sender:"+sender+" Receiver:"+receiverNo+" Message content:"+msgContent+" Message Id:"+messageId+" Status is"+status+" DateTime:"+getFormattedDateTime();
    }
  
}





  
