package models;

/**
 * Created by Justin on 4/16/2017.
 */
public class Building {
    private String name;
    private String mapsName;

    public Building(String name, String mapsName) {
        this.name = name;
        this.mapsName = mapsName;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMapsName(){
        return mapsName;
    }

    public void setMapsName(){
        this.mapsName = mapsName;
    }


}
