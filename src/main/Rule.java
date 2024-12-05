package main;

import java.time.Instant;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Rule {
    Rule(){}

    public static boolean isApproved(Long pressTime, String aiInput, String playerInput){
        if(Instant.now().getEpochSecond() - pressTime > 5)
            return Interface.loseTimeup();
        else if(playerInput.isEmpty() || playerInput.split(" ").length != 1)
            return Interface.loseInvalid();
        else if(!aiInput.isEmpty() && !playerInput.startsWith(String.format("%c", aiInput.charAt(aiInput.length() - 1))))
            return Interface.loseBreak(aiInput.charAt(aiInput.length() - 1));
        
        return true;
    }
}
