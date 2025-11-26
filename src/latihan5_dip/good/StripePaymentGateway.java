package latihan5_dip.good;

public class StripePaymentGateway implements PaymentGateway {
    @Override
    public boolean pay(String cardNumber, int amount) {
        System.out.println("Pembayaran diproses via Stripe...");
        return true;
    }
}
