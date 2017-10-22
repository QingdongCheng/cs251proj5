public class BurrowsWheeler {
    
    private static final int R = 256;
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    public static void encode()
    {
        String message = BinaryStdIn.readString();
        Suffix suffix = new Suffix(message);
        int first = 0;
        while (first < suffix.length() && suffix.index(first) != 0) {
            first++;
        
        }
        
        BinaryStdOut.write(first);
        
        for (int i = 0; i < suffix.length(); i++) {
            BinaryStdOut.write(message.charAt((suffix.index(i) + message.length() - 1) % message.length()));
        }
        
        BinaryStdOut.close();
        
    }
    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode()
    {

    }
    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args)
    {
    	if (args[0].equals("-"))
		encode();
	else if (args[0].equals("+"))
		decode();	
    }
}
