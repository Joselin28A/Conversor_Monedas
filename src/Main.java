
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversionHistory history = new ConversionHistory();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenido al conversor de monedas.");
            System.out.println("Seleccione una opción de conversión:");
            System.out.println("1. Dólar a Peso Argentino (USD a ARS)");
            System.out.println("2. Peso Argentino a Dólar (ARS a USD)");
            System.out.println("3. Dólar a Real Brasileño (USD a BRL)");
            System.out.println("4. Real Brasileño a Dólar (BRL a USD)");
            System.out.println("5. Dólar a Peso Colombiano (USD a COP)");
            System.out.println("6. Peso Colombiano a Dólar (COP a USD)");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 7) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            try {
                String fromCurrency = getFromCurrency(opcion);
                String toCurrency = getToCurrency(opcion);
                double rate = ExchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);
                double result = cantidad * rate;

                System.out.printf("Resultado: %.2f %s%n", result, toCurrency);

                // Registrar en el historial
                ConversionResult conversionResult = new ConversionResult(fromCurrency, toCurrency, cantidad, result);
                history.addConversion(conversionResult);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static String getFromCurrency(int opcion) {
        return switch (opcion) {
            case 1, 3, 5 -> "USD";
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "COP";
            default -> throw new IllegalArgumentException("Opción no válida");
        };
    }

    private static String getToCurrency(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "BRL";
            case 4 -> "USD";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> throw new IllegalArgumentException("Opción no válida");
        };
    }
}
