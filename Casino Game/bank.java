import java.util.Scanner;
public class Bank{
        static  Scanner scanner = new Scanner(System.in);
        static double balance = 400;
        static double cash = 300;
        static boolean inBank = true;
        static int choice;
        static bankAccount myAccount = new bankAccount(300, 300);
        static boolean playing = true;


        static public void runBank(){

                while(inBank){


                System.out.println("***************");
                System.out.println("Banking program");
                System.out.println("****************");
                System.out.println("1. Show Balance");
                System.out.println("2. Show Cash");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Exit");
                System.out.println("***************");
                choice = scanner.nextInt();

                switch(choice){
                        case 1 -> myAccount.showBalance();
                        case 2 -> myAccount.showCash();
                        case 3 -> myAccount.deposit();
                        case 4 -> myAccount.withdraw();
                        case 5 -> inBank = false;
                        default ->System.out.println("Invalid number");

                }
                


                }

        }

        public static class bankAccount{
                double cash;
                double balance;
                double money;

                public bankAccount(double startingCash, double startingBalance){
                        this.cash = startingCash;
                        this.balance = startingBalance;
                }

                public void showBalance(){
                        System.out.printf("Your balance is %.2f\n",this.balance);
                }

                public void showCash(){
                        System.out.printf("Your cash is %.2f\n",this.cash);
                }
                public void withdraw(){
                        System.out.print("Enter the amount of money you want to withdraw: ");
                        money = scanner.nextDouble();
                        if(money <= this.balance && money != 0){
                        this.cash += money;
                        this.balance -= money;
                        System.out.println("Withdrawl completed\n");
                        }
                        else{
                                System.out.println("You don't have enough balance");
                        }



                }
                public void deposit(){
                        System.out.print("Enter the amount of money you want to deposit: ");
                        money = scanner.nextDouble();
                        if(money <= this.cash && money != 0){

                        cash -= money;
                        balance += money;
                        System.out.println("Deposit completed\n");
                        }

                        else{
                                System.out.println("You don't have enough money to deposit");
                        }
                }

        }





        public static void main(String[] args) {
                int gameChoice;

                while(playing){

                        System.out.println("Where do you want to go?");
                        System.out.println("**************************");
                        System.out.println("1. Bank");
                        System.out.println("2. Casino");
                        System.out.println("3. Exit");
                        System.out.println("**************************");
                        gameChoice = scanner.nextInt();
                        switch(gameChoice){
                                case 1 -> runBank();

                                case 3 -> playing = false;

                                default -> System.err.println("invalid number");
                        }






                }





 



                


                }
        }
