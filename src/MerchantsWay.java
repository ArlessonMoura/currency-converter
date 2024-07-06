import java.util.*;

public class MerchantsWay {

    public static void merchantsAssistance() {
        Scanner read = new Scanner(System.in);
        int currencyNumberA = 0;
        boolean validCurrencyA = false;
        HttpServices response = new HttpServices();
        ExchangeRateList rates = response.fetchFullExchangesRates("USD");
        Set<String> currenciesSet = rates.conversion_rates().keySet();
        List<String> currenciesList = new ArrayList<>(currenciesSet);
        int doYouWannaCalc;
        boolean validInputCalc = false;
        double saveMoney;
        int currencyNumberB;
        boolean stopLoop = false;


        System.out.println("""
                    ╔═════════════════════════════════════════════════════════════════════════════╗
                    ║  ░▒▓                                                                   ▓▒░  ║
                    ║  ░▒▓       I got a selection of  good things on sale, stranger!        ▓▒░  ║
                    ║  ░▒▓                                                                   ▓▒░  ║
                    ║  ░▒▓                       What are you selling?                       ▓▒░  ║
                    ║  ░▒▓                                                                   ▓▒░  ║
                    ╚═════════════════════════════════════════════════════════════════════════════╝
                """);


        int counter = 1;
        for (String key : currenciesSet) {
            System.out.print(counter + " - " + key + " ║  ░▒▓▓▒░  ║" + " ");
            if (counter % 5 == 0) {
                System.out.println();
            }
            counter++;
        }
        if ((counter - 1) % 5 != 0) {
            System.out.println();
        }

        System.out.println("""
                    ╔═════════════════════════════════════════════════════════════════════════════╗
                    ║  ░▒▓    - CHOOSE THE NUMBER CORRESPONDING TO THE PRIMARY CURRENCY -    ▓▒░  ║
                    ╚═════════════════════════════════════════════════════════════════════════════╝
                """);

        while (!validCurrencyA) {

            try {
                currencyNumberA = Integer.parseInt(read.nextLine());

                if (currencyNumberA >= 1 && currencyNumberA <= currenciesList.size()) {
                    System.out.println(currenciesList.get(currencyNumberA - 1) + ", Aaah! I'll buy it at a high price!");
                    validCurrencyA = true;
                } else {
                    System.out.println("Invalid number. Please, enter a number between 1 and " +
                            currenciesList.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }

        System.out.println("""
                    ╔════════════════════════════════════════════════════════════════════════════════╗
                    ║ ░▒▓ These are the exchange 1-1 rates for the money that you have on hand! ▓▒░  ║
                    ╚════════════════════════════════════════════════════════════════════════════════╝
                """);


        ExchangeRateList merchantPrices = response.fetchFullExchangesRates(currenciesList.get(currencyNumberA - 1));

        int index = 1;
        for (Map.Entry<String, Double> set : merchantPrices.conversion_rates().entrySet()) {
            System.out.print(set + " ║  ░▒▓▓▒░  ║" + " ");
            if (index % 5 == 0) {
                System.out.println();
            }
            index++;
        }
        if ((index - 1) % 5 != 0) {
            System.out.println();
        }

        System.out.println("""
                    ╔═════════════════════════════════════════════════════════════════════════════╗
                    ║  ░▒▓                                                                   ▓▒░  ║
                    ║  ░▒▓                      Over here, stranger!                         ▓▒░  ║
                    ║  ░▒▓                                                                   ▓▒░  ║
                    ║  ░▒▓            Would you like to calculate your withdrawals           ▓▒░  ║
                    ║  ░▒▓                 and assets in a foreign currency??                ▓▒░  ║
                    ║  ░▒▓                           Press 1 - Yes                           ▓▒░  ║
                    ║  ░▒▓                           Press 2 - No                            ▓▒░  ║
                    ╚═════════════════════════════════════════════════════════════════════════════╝
                """);

        while (!validInputCalc) {

            try {
                doYouWannaCalc = Integer.parseInt(read.nextLine());

                if (doYouWannaCalc == 1) {

                    System.out.println("""
                                        ╔═════════════════════════════════════════════════════════════════════════════╗
                                        ║  ░▒▓    - CHOOSE THE NUMBER CORRESPONDING TO THE COUNTER CURRENCY -    ▓▒░  ║
                                        ╚═════════════════════════════════════════════════════════════════════════════╝
                                    """);

                    while (!stopLoop) {
                        try {

                            currencyNumberB = Integer.parseInt(read.nextLine());


                            if (currencyNumberB >= 1 && currencyNumberB <= currenciesList.size() &&
                                    currencyNumberB != currencyNumberA) {
                                System.out.println("You have chosen " + currenciesList.get(currencyNumberB - 1) + "!");

                                System.out.println(
                                        "Tell me, how many " + currenciesList.get(currencyNumberA - 1) + " do you have?"
                                );
                                saveMoney = Double.parseDouble(read.nextLine());

                                TotalExchangeCalculator calcAmount = new TotalExchangeCalculator();
                                double totalAmount = calcAmount.calculator(
                                        saveMoney, merchantPrices.conversion_rates().get(currenciesList.get(currencyNumberB - 1))
                                );
                                System.out.println("You have " + totalAmount + " " +
                                        currenciesList.get(currencyNumberB - 1) + ". Pick up some rare things on sale, stranger!");
                                stopLoop = true;
                            } else {
                                System.out.println("""
                                            ╔═════════════════════════════════════════════════════════════════════════════╗
                                            ║  ░▒▓  - BE SMART, STRANGER! YOU NEED CHOOSE A VALID CURRENCY NUMBER    ▓▒░  ║
                                            ║  ░▒▓                  AND DIFFERENT FROM THE PRIMARY -                 ▓▒░  ║
                                            ╚═════════════════════════════════════════════════════════════════════════════╝
                                        """);

                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please, enter a number.");
                        }
                    }
                    validInputCalc = true;

                } else if (doYouWannaCalc == 2) {
                    System.out.println("Come back anytime, stranger.");
                    validInputCalc = true;
                } else {
                    System.out.println("Invalid answer, you must choose 1 or 2");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }

    }


}
