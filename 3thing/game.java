public class game {
    public static void main(String[] args) {
        System.out.println("1,2,3" + isNPos(1,2,3));
        System.out.println("1,1,1" + isNPos(1,1,1));
        System.out.println("1,2,1" + isNPos(1,2,1));
        System.out.println("1,2,1" + isNPos(1,2,2));
        System.out.println("1,1,0" + isNPos(1,1,0));
        System.out.println("10,8,2" + isNPos(10,8,2));
        binaryStuff(1,2,3);
        binaryStuff(1,1,1);
        binaryStuff(1,2,1);
        binaryStuff(1,2,2);
        binaryStuff(1,1,0);
        
        
        
    }
    
    public static void binaryStuff(int a, int b, int c) {
        if (!isNPos(a,b,c)){
            System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(b) + " " + Integer.toBinaryString(a) + " ");
        }
    }
    
    public static boolean isNPos(int a, int b, int c) {
        if (a==0 && b==0 && c==0) {
            return false;
        } else if ((a==0 && (b != 0 && c != 0) || (b==0 && (a != 0 && c != 0)) || (c ==0 && (b != 0 && a != 0)))) {
            return false;
        } else if ((a == 0 && b == 0) || (b == 0 && c == 0) || (a == 0 && c == 0)) {
            return true;
        } else {
            return !(isNPos(a-1, b, c) &&  isNPos(a, b-1, c) && isNPos(a, b, c-1));
        }
        //return false;
    }
}