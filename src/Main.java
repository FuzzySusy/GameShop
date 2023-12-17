import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public enum Operation{
        INFO, PURCHASE, RETURN, QUIT
    }

    public static void main(String[] args) {

        Game game1 = new Game();
        game1.setAvailability(false);
        game1.setSupply(0);
        game1.setName("Diablo 4");
        game1.setPrice(80);

        Game game2 = new Game();
        game2.setAvailability(true);
        game2.setName("AoE 4");
        game2.setPrice(40);
        game2.setSupply(100);

        Game game3 = new Game();
        game3.setAvailability(true);
        game3.setName("Hades");
        game3.setPrice(20);
        game3.setSupply(200);

        Game game4 = new Game();
        game4.setAvailability(true);
        game4.setName("CS:Go");
        game4.setPrice(10);
        game4.setSupply(100);

        ArrayList<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);

        Scanner scanner = new Scanner(System.in);
        Budget budget = new Budget();
        boolean running = true;
        while (running){
            System.out.println("Welcome to game shop!\n"+
                    "Info\n"+
                    "Purchase\n"+
                    "Return\n"+
                    "Quit");
            System.out.println("Choose an option to continue : ");
            Operation opt = Operation.valueOf(scanner.next().toUpperCase());
            switch (opt){
                case INFO -> Methods.listGames(games);
                case PURCHASE -> Methods.purchase(games,budget);
                case RETURN -> Methods.toReturn(games,budget);
                case QUIT -> {
                    System.out.println("Bye bye!");
                    running = false;
                }
            }
        }

    }
}