import java.util.Scanner;

/**
 * This program is a mortgage calculator. The user enters loan amount, interest rate and term for the loan, then it
 * shows the balance and monthly payment values for the referred loan.
 */
public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double loanAmount = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        double balance = 0;
        int termInYears;

        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interestRate = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        termInYears = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, termInYears);
        balance = -(monthlyPayment * (termInYears * 12));
        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", balance);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", monthlyPayment);
    }

    // calculates the monthly payment
    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int termInYears) {
        double monthlyRate = (interestRate/ 100) / 12;
        double base = (1 + monthlyRate);
        double termInMonths = termInYears * 12;
        double result = 0.0;
        result = ((monthlyRate * loanAmount) / (1 - Math.pow(base, -termInMonths)));

        return result;
    }
}