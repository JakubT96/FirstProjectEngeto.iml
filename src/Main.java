import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       SaveCountry register = new SaveCountry();
       try {
           register.readCountryFromFile("vat-eu.csv");
       } catch (CountryException e){
           System.out.println("Chyba při načítání souboru:"+ e.getLocalizedMessage());
       }
       //System.out.println("Základní výpis všech položek ze souboru:");
       List<Country> country = register.getCountry();
      // System.out.println(country);
        for (Country oneCountry: country){
            System.out.println(oneCountry.getNameOfCountry() +" ("+ oneCountry.getAbbreviationOfCountry()+"): "+ oneCountry.getFullDph()+" %") ;
        }
        System.out.println("===============================================================================");
        System.out.println("Státy se základní daní vyšší než 20%\n");

        for (Country oneCountry: country){
            if (oneCountry.getFullDph()>20)
            System.out.println(oneCountry.getNameOfCountry() +" ("+ oneCountry.getAbbreviationOfCountry()+"): "+ oneCountry.getFullDph()+" %") ;
        }

    }
//  ukol 4 je vytvořit kolekci collections sort, a seřadit fulldph , vytvořit komparátor
}
