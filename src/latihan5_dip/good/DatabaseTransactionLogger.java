package latihan5_dip.good;

public class DatabaseTransactionLogger implements TransactionLogger {
    @Override
    public void log(String message) {
        System.out.println("[LOG DB] " + message);
    }
}
