import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

       Countryies register = new Countryies();
       try {
           register.readCountryFromFile("vat-eu.csv");
       } catch (CountryException e){
           System.out.println("Chyba při načítání souboru:"+ e.getLocalizedMessage());
       }
        Countryies.enterOrValueFromUser();
        Countryies.processingData();
        register.writeCountryToFile("vat-over-"+Countryies.numberFromUser +".txt");
    }
}

