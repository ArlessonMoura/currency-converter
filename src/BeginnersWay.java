import java.util.Scanner;

public class BeginnersWay {
    public static void beginnersAssistance() {
        Scanner read = new Scanner(System.in);
        int currencyNumberA = 0;
        int currencyNumberB = 0;
        boolean validInputA = false;
        boolean validInputB = false;
        int doYouWannaCalc;
        double saveMoney;
        boolean validInputCalc = false;

        System.out.println("""
                <==================================================================>
                Please, choose a currency couple for pricing exchange rate.
                1 - Real (Brazilian Real) - BRL
                2 - US Dollar - USD
                3 - Peso Argentino (Argentinian Peso) - ARS
                4 - Pound Sterling - GBP
                5 - Euro - EUR
                6 - российский рубль (Russian Ruble) - RUB
                7 - 人民幣 (Chinese Yuan) - CNY
                <==================================================================>
                """);

        while (!validInputA) {
            System.out.println("Enter the number for primary currency (1-7):");

            try {
                currencyNumberA = Integer.parseInt(read.nextLine());

                if (currencyNumberA >= 1 && currencyNumberA <= 7) {
                    validInputA = true;
                } else {
                    System.out.println("Invalid number. Please, enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }

        while (!validInputB) {
            System.out.println("Enter the number for counter currency (1-7):");

            try {
                currencyNumberB = Integer.parseInt(read.nextLine());

                if (currencyNumberB != currencyNumberA && currencyNumberB >= 1 && currencyNumberB <= 7) {
                    validInputB = true;
                } else {
                    if (currencyNumberB == currencyNumberA) {
                        System.out.println("You must choose different currencies from the first." +
                                " Please enter a different number.");
                    }
                    System.out.println("Invalid number. Please, enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }

        HttpServices response = new HttpServices();
        ExchangeRate rate = response.fetchPairExchangeRate(mapNumberToCurrency(currencyNumberA),
                mapNumberToCurrency(currencyNumberB));

        System.out.println("Exchange Rate from " + mapNumberToCurrency(currencyNumberA) + " to "
                + mapNumberToCurrency(currencyNumberB) + " is: " + rate.conversion_rate());


        System.out.println("Do you wanna calculate how many " + mapNumberToCurrency(currencyNumberB) + " you have?");
        System.out.println("""
                1 - Yes
                2 - No
                """);


        while (!validInputCalc) {
            doYouWannaCalc = Integer.parseInt(read.nextLine());
            try {
                if (doYouWannaCalc == 1) {
                    System.out.println("Tell me, how many " + mapNumberToCurrency(currencyNumberA) + " do you have?");
                    saveMoney = Double.parseDouble(read.nextLine());
                    TotalExchangeCalculator calcAmount = new TotalExchangeCalculator();
                    double totalAmount = calcAmount.calculator(saveMoney, rate.conversion_rate());
                    System.out.println("You have " + totalAmount + " " +
                            mapNumberToCurrency(currencyNumberB) + ". Keep it up and Elon Musk will have a rival");
                    validInputCalc = true;

                } else if (doYouWannaCalc == 2) {
                    System.out.println("I understand, these are hard times.");
                    validInputCalc = true;
                } else {
                    System.out.println("Invalid answer, you must choose 1 or 2");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }

    }

    public static String mapNumberToCurrency(int number) {
        return switch (number) {
            case 1 -> "BRL";
            case 2 -> "USD";
            case 3 -> "ARS";
            case 4 -> "GBP";
            case 5 -> "EUR";
            case 6 -> "RUB";
            case 7 -> "CNY";
            default -> "Invalid number";
        };
    }
}
