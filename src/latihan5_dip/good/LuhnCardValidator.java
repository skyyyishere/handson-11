package latihan5_dip.good;

public class LuhnCardValidator implements CardValidator {
    @Override
    public boolean isValid(String card) {
        return card != null && card.length() == 16;
    }
}
