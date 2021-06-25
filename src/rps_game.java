import java.util.Random;
import java.util.Scanner;

public class rps_game {
    public static void main(String[] args) {

        /*
        *
        * to-do:
        *
        * */

        System.out.println("""
                ********************************************
                *         Rock-paper-scissors game         *
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
    private final String[] params = {"Rock","Paper","Scissors"};

    public void beginning(){
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
    public void getParam(){
        System.out.print("You >> ");
        player = sc.next();

        //Проверка ввода
        while (!(params[0].equalsIgnoreCase(player) || params[1].equalsIgnoreCase(player) || params[2].equalsIgnoreCase(player))){
            getParam();
        }
    }

    //Рандомный выбор бота
    public void getBotParam(){
        int rnd = new Random().nextInt(params.length);
        bot = params[rnd];
        System.out.println("Bot >> " + bot);

    }

    //Основной процес
    public void game(){
        getParam();
        getBotParam();

        //Сравнение
        if ((params[0].equalsIgnoreCase(player) && params[2].equalsIgnoreCase(bot)) || (params[1].equalsIgnoreCase(player) && params[0].equalsIgnoreCase(bot)) || (params[2].equalsIgnoreCase(player) && params[1].equalsIgnoreCase(bot))){
            System.out.println("You win!\n");
        }
        else if ((params[2].equalsIgnoreCase(player) && params[0].equalsIgnoreCase(bot)) || (params[0].equalsIgnoreCase(player) && params[1].equalsIgnoreCase(bot)) || (params[1].equalsIgnoreCase(player) && params[2].equalsIgnoreCase(bot))){
            System.out.println("You lose!\n");
        }
        else{
            System.out.println("Tie!\n");
        }
    }
}
