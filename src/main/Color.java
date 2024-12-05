package main;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Color {
    Color(){}

    public static String clear(){
        return "\033[0;m";
    }

    public static String bgClear(){
        return "\033[1;m";
    }

    public static String green(){
        return "\033[1;32m";
    }

    public static String bgGreen(){
        return "\033[1;42m";
    }

    public static String blue(){
        return "\033[1;34m";
    }

    public static String bgBlue(){
        return "\033[1;44m";
    }

    public static String red(){
        return "\033[1;31m";
    }

    public static String bgRed(){
        return "\033[1;41m";
    }
}
