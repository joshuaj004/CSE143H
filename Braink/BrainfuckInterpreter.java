import java.util.*;
import java.io.*;

public class BrainfuckInterpreter {
    private static Scanner input = new Scanner(System.in);
    public static final int LENGTH = 655555;

    /* This function reads a single character of input.
     * This is *not* the brainfuck code.  That is read
     * in from a file.  This is for when you type characters
     * in the console.
     * */
    public static byte readInput() {
        char b = input.next().charAt(0);
        while (b == '\n') {
            b = input.next().charAt(0);
        }
        return (byte)b;
    }

    public static void interpret(String code, byte[] memory, int dataPointer) {
        //byte[] memory = new byte[LENGTH];

        /* This is a pointer into the memory array. */
        //int dataPointer = 0;

        /* This is a pointer into the code string */
        int codePointer = 0;

        while (codePointer < code.length()) {
            if (code.charAt(codePointer) == '<') {
                dataPointer--;
            }
            else if (code.charAt(codePointer) == '>') {
                dataPointer++;
            }
            else if (code.charAt(codePointer) == '+') {
                if (memory[dataPointer] != 255){
                    memory[dataPointer]++;                 
                }                
            }
            else if (code.charAt(codePointer) == '-') {
                if (memory[dataPointer] != 0){
                    memory[dataPointer]--;                 
                }
            }
            else if (code.charAt(codePointer) == '.') {
                System.out.print((char) memory[dataPointer]);
            }
            else if (code.charAt(codePointer) == ',') {
                memory[dataPointer] = (byte) code.charAt(codePointer);
            }
            else if (code.charAt(codePointer) == '[') {
                int count = 1;
                    String tempString = code.substring(codePointer+1, code.indexOf(codePointer));
                    int i = 1;
                    while (count > 0){
                        if (code.charAt(codePointer + i) == ']'){
                            count--;
                        } else if (code.charAt(codePointer + i) == '['){
                            count++;
                        }
                        i++;
                    }
                if (memory[dataPointer] == 0){
                    codePointer += i-1;
                } else {
                    interpret(code.substring(codePointer, codePointer+i), memory, dataPointer);
                }
            }
            else if (code.charAt(codePointer) == ']') {
                //return;
            }
            codePointer++;
        }
        //System.out.println();
        //System.out.print((char) memory[0]);
        //System.out.print((int) memory[0]);

        // Loop through the instructions, executing each one as we get there
        // Each time through the loop, check for each type of instruction...
    }

    public static void main(String[] args) throws Exception {
        String filename = "1-helloworld.txt";

        String code = "";
        Scanner s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            code += s.nextLine();
        }
        System.out.println("Done reading in file.");
        int dataPointer = 0;
        byte[] memory = new byte[LENGTH];
        interpret(code, memory, dataPointer);
    }
}