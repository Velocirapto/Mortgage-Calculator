import java.text.NumberFormat;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte period;

    public MortgageCalculator(int principal, float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public void printMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE:");
        System.out.println("--------------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private double calculateMortgage() {
        float numberOfPayments = period * MONTHS_IN_YEAR;
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        double numerator = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
        return principal * (numerator / denominator);
    }
}

