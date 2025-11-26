package latihan5_dip;

import latihan5_dip.good.*;

public class DIPPractice {

    public static void main(String[] args) {

        // Membuat dependency berbasis abstraksi
        CardValidator validator = new LuhnCardValidator();
        FraudDetector fraudDetector = new RuleBasedFraudDetector();
        PaymentGateway paymentGateway = new StripePaymentGateway();
        TransactionLogger logger = new DatabaseTransactionLogger();
        NotificationSender notifier = new EmailNotificationSender();

        // Inject semua dependency ke PaymentService
        PaymentService service = new PaymentService(
                validator,
                fraudDetector,
                paymentGateway,
                logger,
                notifier
        );

        // Tes transaksi
        boolean result = service.processPayment("4111111111111111", 250000);

        System.out.println("Status transaksi: " + (result ? "BERHASIL" : "GAGAL"));
    }
}
