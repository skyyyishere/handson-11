package latihan5_dip.good;

public class PaymentService {

    private final CardValidator validator;
    private final FraudDetector fraudDetector;
    private final PaymentGateway gateway;
    private final TransactionLogger logger;
    private final NotificationSender notifier;

    public PaymentService(
            CardValidator validator,
            FraudDetector fraudDetector,
            PaymentGateway gateway,
            TransactionLogger logger,
            NotificationSender notifier
    ) {
        this.validator = validator;
        this.fraudDetector = fraudDetector;
        this.gateway = gateway;
        this.logger = logger;
        this.notifier = notifier;
    }

    public boolean processPayment(String cardNumber, int amount) {

        logger.log("Memulai proses pembayaran...");

        if (!validator.isValid(cardNumber)) {
            logger.log("Kartu tidak valid!");
            notifier.notifyUser("Pembayaran gagal: kartu tidak valid.");
            return false;
        }

        if (!fraudDetector.check(cardNumber, amount)) {
            logger.log("Transaksi terindikasi fraud!");
            notifier.notifyUser("Pembayaran gagal: terindikasi fraud.");
            return false;
        }

        boolean paid = gateway.pay(cardNumber, amount);

        if (paid) {
            logger.log("Pembayaran berhasil.");
            notifier.notifyUser("Pembayaranmu berhasil!");
        } else {
            logger.log("Pembayaran gagal.");
            notifier.notifyUser("Pembayaran gagal diproses.");
        }

        return paid;
    }
}
