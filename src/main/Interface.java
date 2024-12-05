package main;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Interface {
    Interface(){}
    
    public static void clear(){
        System.out.print(Config.getMessage("clearCode"));
        System.out.flush();
    }
    
    public static void header(Player player){
        System.out.println(
            Config.getMessage("titleName")
        );
        line(22);
        point(player);
    }

    public static void point(Player player){
        System.out.println(
            Config.getMessage("pointAlert")
            + player.getPoint()
        );
    }
    
    public static void menu(){
        System.out.print(Config.getMessage("menuBar"));
    }
    
    public static void playBar(){
        System.out.println(Config.getMessage("playBar"));
        line(30);
    }

    public static void line(int length){
        System.out.print("\n" + Color.bgBlue()); 
        for(int i = 0; i < length; i++)
            System.out.print(" ");
        System.out.println(Color.bgClear() + "\n");
    }
    
    public static void playerTurn(){
        System.out.print(Config.getMessage("playerTurn"));
    }

    public static void aiTurn(String word){
        String lastChar = String.format("%c", word.charAt(word.length() - 1));
        String formatedLast = String.format(
            "%s%s%s%s", 
            word.substring(0, word.length() - 1), 
            Color.red(),
            lastChar,
            Color.clear()
        );
        System.out.println(String.format(Config.getMessage("aiTurn"), formatedLast));
    }
    
    public static boolean loseTimeup(){
        System.out.print(Config.getMessage("loseTimeup"));
        return false;
    }
    
    public static boolean loseContain(String word){
        System.out.print(String.format(Config.getMessage("loseContain"), word));
        return false;
    }
    
    public static boolean loseInvalid(){
        System.out.print(Config.getMessage("loseInvalid"));
        return false;
    }
    
    public static boolean loseBreak(char last){
        System.out.print(
            String.format(
                Config.getMessage("loseBreak"), 
                last
            )
        );
        return false;
    }
    
    public static void win(){
        System.out.print(Config.getMessage("win"));
    }

    public static void resetPoint(){
        System.out.print(Config.getMessage("resetPoint")); 
    }

    public static void breakLine(){
        System.out.println(Config.getMessage("breakLine"));
    }
}
