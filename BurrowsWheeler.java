public class BurrowsWheeler {
    
    private static final int R = 256; // Radix of a byte.
    
    /**
     * apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
     */
    public static void encode() {
        String s = BinaryStdIn.readString();
        SuffixArray sa = new SuffixArray(s);
        int first = 0;
        
        for (int i = 0; i < sa.length(); i++) {
            if (sa.index(i) == 0) {
                BinaryStdOut.write(i);
                break;
            }
        }
        
        for (int i = 0; i < sa.length(); i++) {
            BinaryStdOut.write(s.charAt((sa.index(i) + s.length() - 1) % s.length()));
        }
        BinaryStdOut.close();
    }
    
    /**
     * apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
     */
    public static void decode() {
        int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();
        int n = t.length();
        int[] count = new int[R + 1], next = new int[n];
        
        int i = 0;
        while(i < n) {
            count[t.charAt(i) + 1]++;
            i++;
        }
        
        i = 1;
        while(i < R + 1) {
            count[i] += count[i - 1];
            i++;
        }
        
        i = 0;
        while(i < n) {
            next[count[t.charAt(i)]] = i;
            count[t.charAt(i)]++;
            i++;
        }
        
        i = next[first];
        for ( int c = 0; c < n; i = next[i], c++)
            BinaryStdOut.write(t.charAt(i));
        BinaryStdOut.close();
    }
    
    /**
     * if args[0] is '-', apply Burrows-Wheeler encoding. if args[0] is '+', apply Burrows-Wheeler decoding
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Please specify: + or -\n");
        else if (args[0].equals("+"))
            decode();
        else if (args[0].equals("-"))
            encode();
        else {
            String msg = "Unknown argument: " + args[0] + "\n";
            throw new IllegalArgumentException(msg);
        }
    }
}
