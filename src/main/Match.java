package main;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Match {
    private Player me;
    private Interface Interface;

    Match(Player me){
        this.me = me;
    }
    
    public int run(){
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> historyTurn = new ArrayList<>();
        Long pressTime;

        String playerInput = "";
        String aiInput = "";
        
        main.Interface.clear();
        main.Interface.playBar();
        main.Interface.point(me);
        main.Interface.breakLine();
        
        while(true){
            pressTime = Instant.now().getEpochSecond();
            main.Interface.playerTurn();
            playerInput = keyboard.nextLine().toLowerCase();
            
            for(String item : historyTurn)
                if((item.contains(playerInput) || playerInput.contains(item)) && playerInput.length() > 1){
                    main.Interface.loseContain(item);
                    return 0;
                }
            
            historyTurn.add(playerInput);
            
            boolean clientSideRule = Rule.isApproved(pressTime, aiInput, playerInput);
            if(!clientSideRule)
                return 0;
                
            String turnResponse = Server.sendTurn(playerInput);
            
            if(turnResponse.equalsIgnoreCase("false") || playerInput.length() <= 1){
                main.Interface.loseInvalid();
                return 0;
            } else if(turnResponse.equalsIgnoreCase("none")){
                main.Interface.win();
                return 1;
            } else {
                aiInput = turnResponse;
                historyTurn.add(aiInput);
                main.Interface.aiTurn(aiInput);
            }
        }
    }
}
