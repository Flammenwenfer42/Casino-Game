import java.util.Random;
import java.util.Scanner;
public class Bank{
        static  Scanner scanner = new Scanner(System.in);
        static Random random = new Random();

        static double balance = 400;
        static double cash = 300;
        static boolean inBank = true;
        static boolean inCasino = false;
        static int choice;
        static bankAccount myAccount = new bankAccount(300, 300);
        static boolean playing = true;
        static boolean inWorld = true;


        static public void runBank(){
                inBank = true;
                inWorld = false;

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
                        case 5 -> {inBank = false;
                                inWorld = true;
                        }
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


    static void coinFlip() {
    boolean playingCoinFlip = true;
            System.out.println("\n--- COIN FLIP GAME ---");

    while (playingCoinFlip) {
        System.out.print("Enter the amount of money you want to bet (or 0 to exit): ");
        double amount = scanner.nextDouble();

        // Exit game if player types 0
        if (amount == 0) {
            playingCoinFlip = false;
            continue;
        }

        // Wallet protection check
        if (amount > myAccount.cash || amount < 0) {
            System.out.println("Invalid bet amount! Please check your cash balance.");
            continue;
        }

        System.out.println("Waiting for coin to land.........");
        
        switch (random.nextInt(1, 3)) {
            case 1 -> {
                System.out.println("YOU WON!!!");
                myAccount.cash += amount;
                System.out.println("You have $ " + myAccount.cash);
                System.out.println("*******************************************************");
            }
            default -> {
                System.out.println("YOU LOST!!!");
                myAccount.cash -= amount;
                System.out.println("*******************************************************");
                System.out.println("You have $ " + myAccount.cash);
            }
        }

        // Kick out player if they run out of money
        if (myAccount.cash <= 0) {
            System.out.println("You are out of cash! Returning to casino menu.");
            playingCoinFlip = false;
        }
    }
}

    static void  blackjack(){
        System.out.println("\n--- Blackjack ---");
        System.out.println("You have: $" + myAccount.cash);
        boolean playingBlackjack = true;
        boolean ingame = true;



        while(playingBlackjack){
        System.out.print("Enter your bet (or 0 to exit): ");
        
        double bet = scanner.nextDouble();
        int playerTotal = random.nextInt(1,12)+random.nextInt(1,12);
        int dealersVisible = random.nextInt(1,12);
        int dealersInvisible = random.nextInt(1,12);
        int dealersTotal = dealersInvisible+dealersVisible;
        boolean PlayerTurn = true;
        if (bet == 0) {
            playingBlackjack = false;
            PlayerTurn = false;
        }
        


        while(PlayerTurn && playerTotal<=21){

                System.out.println("Your hands total is: "+ playerTotal);
                System.out.println("The dealers Visibile hand is: "+ dealersVisible);

                System.out.println("1. Hit\n2.Stand");
                int move = scanner.nextInt();
                if(move == 1){
                        int newCard =random.nextInt(1,12);
                        System.out.println("Your drew a "+newCard);
                        playerTotal += newCard;

                }
                else{
                        PlayerTurn=false;
                }
        }
        if (bet > myAccount.cash || bet < 0) {
            System.out.println("Invalid bet amount!");
        }

        if(playerTotal == 21){
                System.out.println(playerTotal);
                System.out.println("You WON!!");
                myAccount.cash += 1.5*bet;

                }
        else if (playerTotal < dealersTotal && playerTotal < 21){
                System.out.println("You lost!!!");
                myAccount.cash -= 1*bet;
                
        }
        else if (playerTotal > dealersTotal && playerTotal < 21){
                System.out.println("You WON!!");
                myAccount.cash += 1.5*bet;
                
        }
        else if (playerTotal > 21){
                System.out.println("You BUSTED!!!");
                myAccount.cash -= 1.*bet;
                
        }

        System.out.println("--- RESULTS ---");
        
        System.out.println("Dealer's hidden card was: " + dealersInvisible);
        System.out.println("Dealer's final total: " + dealersTotal);
        System.out.println("Your final total: " + playerTotal);
        System.out.println("You have: $" + myAccount.cash);


        }

        }

        static public void runCasino(){
                int casinoChoice;
                inCasino = true;
                inWorld = false;
                while (inCasino){
                System.out.println("Where do you want to go?");
                System.out.println("**************************");
                System.out.println("1. Blackjack");
                System.out.println("2. Slots");
                System.out.println("3. coin flip");
                System.out.println("4. Horse betting");
                System.out.println("5. Exit");

                System.out.println("**************************");
                casinoChoice = scanner.nextInt();
                switch(casinoChoice){
                case 1 -> blackjack();
                case 3 -> coinFlip();
 
                case 5 -> {inCasino = false;
                           inWorld = true;
                }

                default -> System.err.println("invalid number");
        }
        }
        }


        public static void main(String[] args) {
                int gameChoice;

                while(playing){
                        while(inWorld){

                        System.out.println("Where do you want to go?");
                        System.out.println("**************************");
                        System.out.println("1. Bank");
                        System.out.println("2. Casino");
                        System.out.println("3. Exit");
                        System.out.println("**************************");
                        gameChoice = scanner.nextInt();
                        switch(gameChoice){
                                case 1 -> runBank();
                                case 2 -> runCasino();
                                case 3 -> {playing = false;
                                           inWorld = false;
                                }

                                default -> System.err.println("invalid number");
                        }
                }

                }

                }
        }
