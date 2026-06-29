import java.util.Scanner;
public class main{

        static class bankAccount{
                double cash;
                double balance;
                double money;

                public bankAccount(double startingCash, double startingBalance){
                        this.cash = startingCash;
                        this.balance = startingBalance;
                }

                public void showBalance(){
                        System.out.printf("Your balance is %.2f",this.balance);
                }

                public void showCash(){
                        System.out.printf("Your cash is %.2f",this.cash);
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
                        if(money <= this.cash && money != 0){

                        
                        System.out.print("Enter the amount of money you want to deposit: ");
                        money = scanner.nextDouble();

                        cash -= money;
                        balance += money;
                        System.out.println("Deposit completed\n");
                        }
                        else{
                                System.out.println("You don't have enough money to deposit");
                        }
                }

        }

        static  Scanner scanner = new Scanner(System.in);
        static double balance = 1000;
        static double cash = 1000;




        public static void main(String[] args) {
                boolean running = true;
                int choice;
                double accCash;
                double accBalance;

                System.out.print("Enter the amount of cash you want to have: ");
                accCash = scanner.nextDouble();


                System.out.print("Enter the amount of balance in your account: ");
                accBalance = scanner.nextDouble();




                bankAccount myAccount = new bankAccount(accCash, accBalance);


                while(running){


                System.out.println("**********");
                System.out.println("Banking program");
                System.out.println("**********");
                System.out.println("1. Show Balance");
                System.out.println("2. Show Cash");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Exit");
                System.out.println("**********");
                choice = scanner.nextInt();

                switch(choice){
                        case 1 -> myAccount.showBalance();
                        case 2 -> myAccount.showCash();
                        case 3 -> myAccount.deposit();
                        case 4 -> myAccount.withdraw();
                        case 5 -> running = false;
                        default ->System.out.println("Invalid number");

                }
                


                }
        }

        /* This is a multi-line comment
   that allows you to write longer
   explanations or descriptions. 
        static void showBalance(double Balance){
                System.out.printf("Your balance is %.2f\n",Balance);

}
        static void cash(double mon){
                System.out.printf("You have %.2f in cash\n",mon);
        }
        static void deposit(){
                System.out.print("Enter the amount you want to deposit: ");
                double money = scanner.nextDouble();

                if (money <= cash){
                        balance += money;
                        cash -= money;
                        System.out.println("Funds had been deposited succesfully\n");
                }
                else{
                        System.out.println("You don't have enough funds to deposit\n");

                }
        }
        static void withdraw(){
                System.out.print("Enter the amount you want to withdraw: ");
                double money = scanner.nextDouble();


                if (money <= balance){

                        cash += money;
                        balance -= money;
                        System.out.println("Withdrawl completed\n");


                }
                else{
                        System.out.println("You don't have enough money in your account\n");

                }
        }
*/
}