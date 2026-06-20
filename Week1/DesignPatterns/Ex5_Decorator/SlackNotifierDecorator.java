public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending slack message: " + msg);
    }
}