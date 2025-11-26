package latihan5_dip.good;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void notifyUser(String message) {
        System.out.println("[EMAIL] " + message);
    }
}
