package main;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Config {
    Config(){}

    public static int reward(){
        return 5;
    }
    
    public static String getMessage(String code){
        switch(code){
            case "clearCode":
                return "\033[H\033[2J";
            case "titleName":
                return "WORDCHAIN";
            case "pointAlert":
                return "Point wallet: ";
            case "breakLine":
                return "------------------------------";
            case "menuBar":
                return String.format(
                    "(%sP%s) Play new game\n"
                    + "(%sR%s) Reset your account\n"
                    + "(%sE%s) Exit\n"
                    + "\n> ", Color.blue(), Color.clear(), Color.blue(), Color.clear(), Color.blue(), Color.clear());
            case "playBar":
                return "You VS Gemini (AI)";
            case "playerTurn":
                return String.format("%s>%s ", Color.blue(), Color.clear());
            case "aiTurn":
                return ("%40s " + Color.blue() + "<" + Color.clear());
            case "loseContain":
                return ("\n[" + Color.red() + "LOSE" + Color.clear() + "] Answer contain '%s'");
            case "loseInvalid":
                return ("\n[" + Color.red() + "LOSE" + Color.clear() + "] Invalid word");
            case "loseTimeup":
                return ("\n[" + Color.red() + "LOSE" + Color.clear() + "] Time up");
            case "loseBreak":
                return ("\n[" + Color.red() + "LOSE" + Color.clear() + "] Not start with '%c'");
            case "win":
                return ("\n[" + Color.green() + "WIN" + Color.clear() + "] +5 points");
            case "resetPoint":
                return "Your account was resetted, please restart to begin new data";
            default:
                return "";
        }
    }
}
