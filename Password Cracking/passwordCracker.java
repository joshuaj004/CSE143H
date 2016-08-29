import java.util.Scanner;
import java.io.*;
import java.lang.Character; 

public class passwordCracker{
    public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("rockyou.txt"));
    PrintStream output = new PrintStream("plainwords.txt");
    
    while (input.hasNextLine()){
        String line = input.nextLine();
        Scanner lines = new Scanner(line);
        if (lines.nextInt() >= 1000){
            String password = lines.next(); 
            output.println(truncate(password));
                      
            
        } else {
            return;
        }
    }
    } 
    
    public static String truncate(String input) { 
       int i = input.length() - 1;
       while(i >= 0 && Character.isDigit(input.charAt(i))) { i--; }
       if (i == -1) {
          return input;
       } else {
          return input.substring(0, i+1);
       }
    }
}

