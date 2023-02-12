import java.io.IOException;

public class Main {


    public static final String VAT_OVER =  "vat-over-";
    public static final String TXT = ".txt";

    public static void main(String[] args) throws IOException {

       Countryies register = new Countryies();
       try {
           register.readCountryFromFile("vat-eu.csv");
       } catch (CountryException e){
           System.out.println("Chyba při načítání souboru:"+ e.getLocalizedMessage());
       }
        Countryies.enterOrValueFromUser();
        Countryies.processingData();
        register.writeCountryToFile(VAT_OVER +Countryies.numberFromUser + TXT);
    }
}

