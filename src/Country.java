public class Country {
    String abbreviationOfCountry;
     String nameOfCountry;
     double fullDph;
     double reducetDph;
     boolean specialDph;

    public Country(String abbreviationOfCountry, String nameOfCountry, double fullDph, double reducetDph, boolean specialDph) {
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

    public double getFullDph() {
        return fullDph;
    }

    public void setFullDph(double fullDph) {
        this.fullDph = fullDph;
    }

    public double getReducetDph() {
        return reducetDph;
    }

    public void setReducetDph(double reducetDph) {
        this.reducetDph = reducetDph;
    }

    public boolean isSpecialDph() {
        return specialDph;
    }

    public void setSpecialDph(boolean specialDph) {
        this.specialDph = specialDph;
    }


    @Override
    public String toString(){
        return " "+abbreviationOfCountry+ " "+
                " "+ nameOfCountry+ " " +
                " " + fullDph + " " +
                " " + reducetDph + " " +
                " " + specialDph + "\n";
    }


    }

