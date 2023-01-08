import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String OUTPUT_FILENAME = "vat-over-20.txt";

    public static void main(String[] args) throws IOException {

       SaveCountry register = new SaveCountry();
       try {
           register.readCountryFromFile("vat-eu.csv");
       } catch (CountryException e){
           System.out.println("Chyba při načítání souboru:"+ e.getLocalizedMessage());
       }
     /*
        List<Country> country = register.getCountry();
    Collections.sort(country,
            new Comparator<Country>() {
                @Override
                public int compare(Country country1, Country country2) {
                    return country2.getFullDph()- country1.getFullDph();
                }
    });
        System.out.println("Zadej číslo výše DPH/VAT: ");
        Scanner sc = new Scanner(System.in);
        int numberFromUser= sc.nextInt();
        System.out.println("Zadal jsi: "+ numberFromUser);
        for (Country oneCountry: country){
            if (oneCountry.getFullDph()>numberFromUser)
                System.out.println(oneCountry.getNameOfCountry() +" ("+ oneCountry.getAbbreviationOfCountry()+"): "+ oneCountry.getFullDph()+" %" + "  ("+ oneCountry.getReducetDph()+ " %)") ;
        }
        System.out.println("===============================================================================");
        System.out.print("Sazba VAT "+ numberFromUser + " % nebo nižší nebo používají speciální sazbu: ");
        for (Country oneCountry: country){
            if (oneCountry.getFullDph()<numberFromUser)
                System.out.print(oneCountry.getAbbreviationOfCountry()+ ", ");

        }
        for (Country oneCountry: country){
            if (oneCountry.specialDph == true  )
                System.out.print(oneCountry.getAbbreviationOfCountry()+ ", ");

        }*/
        SaveCountry.processingData();
        register.writeCountryToFile(OUTPUT_FILENAME);
    }
}