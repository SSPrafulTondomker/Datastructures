package designPatterns;


interface NotificationSender {
    void sendNotification();
}
class SMS implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("We are going to send SMS");
    }

}
 class Email implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Sending an Email");
    }
}

 abstract class Notification {
    NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract void sendMessage();
}


class QRMessage extends Notification{
    public QRMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is the QR Code");
    }

    @Override
    void sendMessage() {
        //call some method to build QRCode
        notificationSender.sendNotification();
    }
}

class TextMessage extends Notification {

    public TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a text message");
    }

    @Override
    void sendMessage() {
        notificationSender.sendNotification();
    }
}





public class BridgePattern {
    public static void main(String[] args){
        QRMessage qrMessage = new QRMessage(new SMS());
        qrMessage.sendMessage();
    }
}
