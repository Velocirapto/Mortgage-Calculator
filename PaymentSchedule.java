import java.text.NumberFormat;

public class PaymentSchedule {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte period;

    public PaymentSchedule(int principal, float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE:");
        System.out.println("--------------");
        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        float numberOfPayments = period * MONTHS_IN_YEAR;
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        return principal * (Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}
