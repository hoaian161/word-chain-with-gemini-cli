package main;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Player {
    private int point;
    
    Player(){}
    
    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point){
        this.point = point;
        this.savePoint();
    }
    
    public void savePoint(){
        Database.set("point", Integer.toString(this.point));
    }
    
    public void restorePoint(){
        ArrayList<String> getDb = Database.get("point");
        this.point = Integer.parseInt(getDb.get(0));
    }

    public void resetPoint(){
        setPoint(5);
    }
}