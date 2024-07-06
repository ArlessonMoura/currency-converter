import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int systemChoose;
        boolean validSystem = false;

        System.out.println("""
                <==================================================================>
                                        █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
                                        █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
                                        █░░║║║╠─║─║─║║║║║╠─░░█
                                        █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
                                        █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
                               The Currency Exchange International Bank
                                               CEIB Corp.
                
                                        Press Enter to continue
                <==================================================================>
                """);

        read.nextLine();

        System.out.println("""
                <==================================================================>
                                 Would you like access to our system for
                                      Expert or Beginner clients?
                
                                            PRESS TO ACCESS:
                                              1 - Expert
                                              2 - Beginner
                <==================================================================>
                """);

        while (!validSystem) {

            try {
                systemChoose = Integer.parseInt(read.nextLine());

                if (systemChoose == 1) {
                    validSystem = true;
                    //MerchantsWay merchant = new MerchantsWay();
                    MerchantsWay.merchantsAssistance();
                } else if (systemChoose == 2) {
                    validSystem = true;
                    //BeginnersWay beginner = new BeginnersWay();
                    BeginnersWay.beginnersAssistance();
                } else {
                    System.out.println("Invalid number. Please, choose system 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please, enter a number.");
            }
        }
    }

}

