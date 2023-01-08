import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Country {
    String abbreviationOfCountry;
     String nameOfCountry;
     int fullDph;
     String reducetDph;
    boolean specialDph;

    public Country(String abbreviationOfCountry, String nameOfCountry, int fullDph, String reducetDph, boolean specialDph) {
        this.abbreviationOfCountry = abbreviationOfCountry;
        this.nameOfCountry = nameOfCountry;
        this.fullDph = fullDph;
        this.reducetDph = reducetDph;
        this.specialDph = specialDph;
    }

    public String getAbbreviationOfCountry() {
        return abbreviationOfCountry;
    }

    public void setAbbreviationOfCountry(String abbreviationOfCountry) {
        this.abbreviationOfCountry = abbreviationOfCountry;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public int getFullDph() {
        return fullDph;
    }

    public void setFullDph(int fullDph) {
        this.fullDph = fullDph;
    }

    public String getReducetDph() {
        return reducetDph;
    }

    public void setReducetDph(String reducetDph) {
        this.reducetDph = reducetDph;
    }

    public boolean isSpecialDph() {
        return specialDph;
    }

    public void setSpecialDph(boolean specialDph) {
        this.specialDph = specialDph;
    }

    public String toString(){
        return " "+abbreviationOfCountry+ " "+
                " "+ nameOfCountry+ " " +
                " " + fullDph + " " +
                " " + reducetDph + " " +
                " " + specialDph + "\n";
    }


    }

