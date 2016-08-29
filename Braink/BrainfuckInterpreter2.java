import java.util.*;
import java.io.*;

public class BrainfuckInterpreter2 {
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
                memory[dataPointer]++;
            }
            else if (code.charAt(codePointer) == '-') {
                memory[dataPointer]--;
            }
            else if (code.charAt(codePointer) == '.') {
                System.out.print((char) memory[dataPointer]);
            }
            else if (code.charAt(codePointer) == ',') {
                memory[dataPointer] = (byte) code.charAt(codePointer);
            }
            else if (code.charAt(codePointer) == '[') {
                //System.out.println(dataPointer + " dataPointer " + memory[dataPointer]);
                for (int i = 0; i < 5; i++){
                    //System.out.println("i " + i);
                    interpret(code.substring(codePointer+1, code.indexOf("]")), memory, dataPointer);
                }
                //System.out.println("Line 53");
            }
            else if (code.charAt(codePointer) == ']') {
                break;
            }
            codePointer++;
        }
        //System.out.println();
        //System.out.println("TestA");
        System.out.print((int) memory[0]+"**"+(int) memory[1]);
        //System.out.println();
        //System.out.println("TestB");
        System.out.println();

        // Loop through the instructions, executing each one as we get there
        // Each time through the loop, check for each type of instruction...
    }

    public static void main(String[] args) throws Exception {
        String filename = "a.txt";

        String code = "";
        Scanner s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            code += s.nextLine();
        }
        System.out.println("Done reading in file.");
        byte[] memory = new byte[LENGTH];
        int dataPointer = 0;
        interpret(code, memory, dataPointer);
    }
}