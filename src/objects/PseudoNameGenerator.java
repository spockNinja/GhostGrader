package objects;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.io.InputStream;
import java.io.IOException;

/**
 * Write a description of class PseudoNameGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PseudoNameGenerator
{
    private Set<String> usedNames = new HashSet<String>();
    private ArrayList<String> animals = new ArrayList<String>();
    private ArrayList<String> colors = new ArrayList<String>();
     
    //load the color and animal name files and put them into arrays
    
    

    public PseudoNameGenerator() {
        InputStream animalsStream = this.getClass().getResourceAsStream("/res/animals.txt");
        InputStream colorsStream = this.getClass().getResourceAsStream("/res/colors.txt");

        if (animalsStream == null || colorsStream == null) {
            System.err.println("Unable to load PseudoName text files.");
            return;
        }

        Scanner animalScanner = new Scanner(animalsStream);
        Scanner colorScanner = new Scanner(colorsStream);

        while(animalScanner.hasNextLine()){
            animals.add(animalScanner.next());
        }
        while(colorScanner.hasNextLine()){
            String result = colorScanner.next();
            result = result.replaceAll("(.)([A-Z])", "$1 $2");
            colors.add(result);
        }
        animalScanner.close();
        colorScanner.close();
    }
    
    public String generateName() {
        //randomly choose a color and an animal
        //check that they are not in usedNames
        //if name is unique to usedNames(maybe make this a set) then add the name in
        Random generator = new Random();
        
        int randomArrayIndex = 0;
        
        String colorName = "";
        
        String animalName = "";
        String PseudoName = "";
        
        do{
            randomArrayIndex = generator.nextInt(colors.size()-1);
        
            colorName = colors.get(randomArrayIndex);
        
            randomArrayIndex = generator.nextInt(animals.size()-1);
        
            animalName = animals.get(randomArrayIndex);
        
            PseudoName = (colorName + " " + animalName);
        }while(usedNames.contains(PseudoName));
        
        usedNames.add(PseudoName);
        
        return PseudoName;
    }
}
