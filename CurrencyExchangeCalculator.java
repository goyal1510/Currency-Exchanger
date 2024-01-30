import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchangeCalculator {
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    static {
        // Initialize exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 109.86);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Currency Exchange Calculator");
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency code: ");
        String sourceCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedAmount = decimalFormat.format(convertedAmount);
        System.out.println(amount + " " + sourceCurrency + " = " + formattedAmount + " " + targetCurrency);
        scanner.close();
    }

    public static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(sourceCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double sourceRate = exchangeRates.get(sourceCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return amount * (targetRate / sourceRate);
        } else {
            throw new IllegalArgumentException("Invalid currency code.");
        }
    }
}