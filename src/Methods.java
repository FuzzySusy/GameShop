import java.util.List;
import java.util.Scanner;

public class Methods {
    Scanner scanner = new Scanner(System.in);
    String option = scanner.nextLine();


    public static void listGames(List<Game> games){
        for (Game game : games)
            System.out.println(game.getName());
    }
    public static void purchase(List<Game> games, Budget budget){

        boolean running = true;
        while (running){
            boolean gameFound = false;
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which game do you want to buy? : ");
            System.out.println("Press m to return to menu");
            String chosenGame = scanner1.nextLine();

            for (Game game : games){
                if (chosenGame.equalsIgnoreCase("m")) running = false;
                else if (chosenGame.equalsIgnoreCase(game.getName()) && game.isAvailability()){
                    gameFound = true;
                    System.out.println("Name : "+game.getName());
                    System.out.println("Price : "+game.getPrice());
                    System.out.println("Supply : "+game.getSupply());
                    areYouSure(running);
                    buy(game,budget,running); break;
                }
                else if (chosenGame.equalsIgnoreCase(game.getName()) && !game.isAvailability()) {
                    gameFound = true;
                    System.out.println("Game is not available!"); break;
                }
                else System.out.println("Game is not in the catalog!"); break;

            }
        }
    }

    public static void areYouSure(boolean running){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Do you want to continue? : y/n");
        String answer = scanner1.nextLine();
        if (!answer.equalsIgnoreCase("y")) running = false;
    }

    public static void buy(Game game,Budget budget,boolean running){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter your payment : ");
        System.out.println("Press m to return menu");
        int payment = scanner1.nextInt();
        if (payment == Integer.parseInt("m")){
            running  =false;
        }
        int change = payment - game.getPrice();
        if (change < 0){
            System.out.println("Insufficient payment!");}
        else {
            System.out.println("Enjoy your game!");

            System.out.println("Your change is  "+change);

            int newSupply = game.getSupply() -1;
            game.setSupply(newSupply);
            System.out.println(game.getSupply());

            int newBudget = budget.getBudget() + game.getPrice();
            budget.setBudget(newBudget);
            System.out.println(budget.getBudget());

                if (game.getSupply() == 0){
                    System.out.println("Current supply of the game is"+game.getSupply()+
                        ".The game is out of stock now!");
                    game.setAvailability(false);
                }
                if (game.getSupply() > 0){
                    game.setAvailability(true);
                    System.out.println("Yay we have the game now!");
                    System.out.println("Current supply of the game is "+game.getSupply());
                }
        }

    }

    public static void toReturn(List<Game> games, Budget budget){

        boolean running = true;
        while (running){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which game do you want to return? : ");
            System.out.println("Press m to return to menu");
            String returnedGame = scanner1.nextLine();
            if (returnedGame.equalsIgnoreCase("m")) running = false;
            for (Game game : games){
                if (returnedGame.equalsIgnoreCase(game.getName())){
                    areYouSure(running);
                    System.out.println("Your return is successful!");
                    System.out.println("Your refund is : "+game.getPrice());

                    int newSupply = game.getSupply() + 1;
                    game.setSupply(newSupply);
                    System.out.println("Current supply of the game : "+game.getSupply());

                    int newBudget = budget.getBudget() - game.getPrice();
                    System.out.println("Current budget of the shop : "+newBudget);

                        if (game.getSupply() == 0){
                        System.out.println("Current supply of the game is"+game.getSupply()+
                                ".The game is out of stock now!");
                        game.setAvailability(false);}
                        if (game.getSupply() > 0){
                        game.setAvailability(true);
                        System.out.println("Yay we have the game now!");
                        System.out.println("Current supply of the game is "+game.getSupply());
                        } break;
                }else System.out.println("Game is not in the catalog!");
            }

        }
    }
}



