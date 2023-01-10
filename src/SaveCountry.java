import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.*;

public class SaveCountry {

    static Scanner sc = new Scanner(System.in);
    static SaveCountry register = new SaveCountry();
    private static List<Country> country = new ArrayList<>();
    public void addCountry (Country newCountry){country.add(newCountry);}
    public static List<Country>getCountry(){return new ArrayList<>(country);}
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

    public static float enterOrValueFromUser() {

        System.out.println("Zadej hodnotu nebo Enter:");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        if (item == ""){
            System.out.println("Zadal jsi Enter a proto hodnotu nastavuji na 20.\n");
             numberFromUser= 20;
        }
        else {
            numberFromUser = Integer.parseInt(item);
        }
        return numberFromUser;
    }
    static float numberFromUser;
    public static void processingData () {
        Collections.sort(country,
                new Comparator<Country>() {
                    @Override
                    public int compare(Country country1, Country country2) {
                        return country2.getFullDph()- country1.getFullDph();
                    }

                });
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


        }
    }
    public void writeCountryToFile(String filename) throws IOException {  // zápis do souboru ( ulozí novy soubor)
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Country country: SaveCountry.getCountry()){
                if (country.getFullDph()>numberFromUser){
                String outputLineOne = country.getNameOfCountry()+" ("
                        + country.getAbbreviationOfCountry()+ "): "
                        + country.getFullDph() + " % ("
                        + country.getReducetDph()+ "%)";
                writer.println(outputLineOne);
                }

        }
            String outputLineTwo =
                    ("=============================================================================== \n")
            + "Sazba VAT "+ numberFromUser + " % nebo nižší nebo používají speciální sazbu: ";
            writer.print(outputLineTwo);

            for (Country country: SaveCountry.getCountry()){
                if (country.specialDph == true  ){
                    String outputLineThree = country.getAbbreviationOfCountry() + ", ";
                    writer.print(outputLineThree);
                }}
            for (Country country: SaveCountry.getCountry()){
                      if (country.getFullDph()<numberFromUser){
                            String outputLineFour= country.getAbbreviationOfCountry() + ", ";
                    writer.print(outputLineFour);}
                }

        }
    }
}
