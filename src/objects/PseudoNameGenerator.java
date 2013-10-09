package objects;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

/**
 * Write a description of class PseudoNameGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PseudoNameGenerator
{
    HashSet usedNames = new HashSet();
    ArrayList<String> animals = new ArrayList<>();
    ArrayList<String> colors = new ArrayList<>();
     
    //load the color and animal name files and put them into arrays
    
    

    public PseudoNameGenerator() {
        try {
        Scanner animalScanner = new Scanner(new File("animals.txt"));
        Scanner colorScanner = new Scanner(new File("colors.txt"));
        
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
            
		} catch(FileNotFoundException e){
			System.out.println(e);
		}
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
