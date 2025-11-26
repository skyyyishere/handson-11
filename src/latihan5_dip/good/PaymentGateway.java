package latihan5_dip.good;

public interface PaymentGateway {
    boolean pay(String cardNumber, int amount);
}
