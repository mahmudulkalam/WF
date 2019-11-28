/******************************************************************************
*Mahmudul Kalam | 23513687
*
* This program reads song lyrics from a file and counts how many times each word appears
******************************************************************************/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencies {
  public static void main(String []args){
    Scanner s = new Scanner(System.in);
    
//Reading text from file
    String fileName = "lyrics.txt"; //s.nextLine();
    
    wordCounter(System.getProperty("user.dir"),fileName);
  }
  
  public static void wordCounter(String directory, String fileName) {
    
// Declare the HashMap
    HashMap<String, Integer> wordCount = new HashMap();
    
// Puts together the string that the FileReader will refer to.
    String fileNameWithDirectory = directory+ "\\\\" + fileName;
    
    try {
      FileReader reader = new FileReader(fileNameWithDirectory);
      BufferedReader br = new BufferedReader(reader);
// The BufferedReader reads the lines
      
      String strCurrentLine;
      while ((strCurrentLine = br.readLine()) != null) {
        
// Separates all characters that aren't letters and lowercase characters
// \\s+ - matches sequence of one or more whitespace characters.
        
        String[] words = strCurrentLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        int freq = 0;
        
// for loop that searches through every word 
        for (int i = 0; i < words.length; i++) {
          
// Case if the HashMap already contains the key
          
          if (wordCount.containsKey(words[i])) {
            int n = wordCount.get(words[i]);
            wordCount.put(words[i], ++n);
          }
// Else places word in hashmap
          else {
            wordCount.put(words[i], 1);
          }
        }
      }
      
      for (Map.Entry entry : wordCount.entrySet())
        System.out.println(entry.getValue() + ": " + entry.getKey());
      
// Error shown when file is empty
      
    }
    catch (NullPointerException e) {
      System.err.println("File is empty.");
    }
    catch (Exception e) {
      System.err.print(e);
    }
    
  }
}

