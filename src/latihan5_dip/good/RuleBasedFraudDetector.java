package latihan5_dip.good;

public class RuleBasedFraudDetector implements FraudDetector {
    @Override
    public boolean check(String cardNumber, int amount) {
        return amount < 10000000; // tidak curiga jika < 10 juta
    }
}
