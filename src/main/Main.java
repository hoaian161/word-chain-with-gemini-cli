package main;

import java.util.Scanner;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Main {
    public static void main(String[] args){
        try (Scanner keyboard = new Scanner(System.in)) {
            Player me = new Player();
            me.restorePoint();
            
            String choice = "";
            do {
                Interface.clear();
                Interface.header(me);
                Interface.menu();
                choice = keyboard.nextLine();
                
                switch(choice.toLowerCase()){
                    case "p":
                        Match newMatch = new Match(me);
                        int match = newMatch.run();

                        me.setPoint(me.getPoint() + (match == 1 ? Config.reward() : -Config.reward()));
                        keyboard.nextLine();
                        break;
                    case "r":
                        me.resetPoint();

                        Interface.resetPoint();
                        keyboard.nextLine();
                        break;
                    default:
                        break;
                }
            } while(!choice.equalsIgnoreCase("e"));
        }
    }
}
