import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class rps_game {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("""
                ********************************************
                *         Rock-Paper-Scissors game         *
                *                                          *
                * Choose between rock, paper or scissors   *
                * and try to win bot.                      *
                *                                          *
                ********************************************
                """);

        Rps rps = new Rps();
        while (true){
            rps.beginning();
        }
    }
}

class Rps{
    Scanner sc = new Scanner(System.in);

    private String player;
    private String bot;
    private final String[] params = {"Rock", "Paper", "Scissors"};

    public void beginning() throws InterruptedException {
        System.out.print("Do you want to start? >> ");
        String start = sc.next();
        System.out.println();

        if ("Yes".equalsIgnoreCase(start)){
            game();
        }
        else{
            System.exit(0);
        }
    }

    //Ввод пользователя
    private void getParam(){
        System.out.print("You >> ");
        player = sc.next();

        //Проверка ввода
        while (!(params[0].equalsIgnoreCase(player) || params[1].equalsIgnoreCase(player) || params[2].equalsIgnoreCase(player))){
            getParam();
        }
    }

    //Рандомный выбор бота
    private void getBotParam(){
        int rnd = new Random().nextInt(params.length);
        bot = params[rnd];
        System.out.println("Bot >> " + bot);

    }

    //Основной процес
    private void game() throws InterruptedException {
        getParam();
        TimeUnit.MILLISECONDS.sleep(500);
        getBotParam();

        TimeUnit.MILLISECONDS.sleep(400);
        //Сравнение
        if ((params[0].equalsIgnoreCase(player) && params[2].equalsIgnoreCase(bot)) ||
                (params[1].equalsIgnoreCase(player) && params[0].equalsIgnoreCase(bot)) ||
                (params[2].equalsIgnoreCase(player) && params[1].equalsIgnoreCase(bot))){

            System.out.println("You win!\n");
        }
        else if ((params[2].equalsIgnoreCase(player) && params[0].equalsIgnoreCase(bot)) ||
                (params[0].equalsIgnoreCase(player) && params[1].equalsIgnoreCase(bot)) ||
                (params[1].equalsIgnoreCase(player) && params[2].equalsIgnoreCase(bot))){

            System.out.println("You lose!\n");
        }
        else{
            System.out.println("Tie!\n");
        }
    }
}
