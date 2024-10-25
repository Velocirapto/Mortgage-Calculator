import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) ConsoleReader.readNumber("Principal: ", 1_000, 1_000_000);
        float interestRate = (float) ConsoleReader.readNumber("Annual Interest Rate: ", 0, 30);
        byte period = (byte) ConsoleReader.readNumber("Period (Years): ", 1, 30);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, interestRate, period);
        PaymentSchedule paymentSchedule = new PaymentSchedule(principal, interestRate, period);

        mortgageCalculator.printMortgage();
        paymentSchedule.printPaymentSchedule();
    }
}