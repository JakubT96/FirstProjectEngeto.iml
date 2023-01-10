import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String OUTPUT_FILENAME = "vat-over-"+ SaveCountry.numberFromUser+".txt";
    public static void main(String[] args) throws IOException {

       SaveCountry register = new SaveCountry();
       try {
           register.readCountryFromFile("vat-eu.csv");
       } catch (CountryException e){
           System.out.println("Chyba při načítání souboru:"+ e.getLocalizedMessage());
       }

        SaveCountry.enterOrValueFromUser();
        SaveCountry.processingData();
        register.writeCountryToFile(OUTPUT_FILENAME);
    }
}