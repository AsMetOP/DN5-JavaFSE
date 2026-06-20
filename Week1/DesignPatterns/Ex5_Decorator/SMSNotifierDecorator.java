public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending sms: " + msg);
    }
}