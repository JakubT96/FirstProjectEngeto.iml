import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveCountry {
    private static List<Country> country = new ArrayList<>();
    public void addCountry (Country newCountry){country.add(newCountry);}
    public List<Country>getCountry(){return new ArrayList<>(country);}
    public void readCountryFromFile (String filename) throws CountryException {
        String nextLine =null;
        String [] items = new String[0];
        String abbreviationOfCountry = null;
        String nameOfCountry = null;
        int fullDph ;
        String reducetDph = null;
        boolean specialDph ;
        int lineNumber = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            while (scanner.hasNextLine()){
            lineNumber ++;
            nextLine= scanner.nextLine();
            items = nextLine.split("\t");
            abbreviationOfCountry = items[0];
            nameOfCountry= items[1];
            fullDph= Integer.parseInt(items [2]);
            reducetDph= items [3];
            double reducetToDouble = DecimalFormat.getNumberInstance().parse(reducetDph).doubleValue();
            reducetDph= String.valueOf(reducetToDouble);  // zdroj: https://www.digitalocean.com/community/tutorials/java-convert-string-to-double
            specialDph = Boolean.parseBoolean(items [4]);
            Country newCountry= new Country(abbreviationOfCountry, nameOfCountry, fullDph, reducetDph,specialDph);
            addCountry(newCountry);
        }
    }
        catch (FileNotFoundException e){
            throw new CountryException("Nepodařilo se najít soubor"+ filename+ " "+ e.getLocalizedMessage());
        }
        catch (DateTimeException e){
            throw new CountryException("Špatný formát data:"+items[2]+"nebo"+items[3]+"nebo"+items[4]+ lineNumber);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}