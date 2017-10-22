import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {
    
    private static final int CUTOFF = 15;
    private Integer[] index;
    private int n;
    
    public SuffixArray(String input) {
        n = input.length();
        index = new Integer[n];
        for (int i = 0; i < input.length(); i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                
                int firstIndex = first;
                int secondIndex = second;
              
                for (int i = 0; i < input.length(); i++) {
                    // if it reaches the end, start from beginning
                    if (firstIndex > input.length() - 1)
                        firstIndex = 0;
                    if (secondIndex > input.length() - 1)
                        secondIndex = 0;
                    // first < second
                    if (input.charAt(firstIndex) < input.charAt(secondIndex))
                        return -1;
                    //  first > second
                    else if (input.charAt(firstIndex) > input.charAt(secondIndex))
                        return 1;
                    // check next chars
                    firstIndex++;
                    secondIndex++;
                }
                // equal
                return 0;
            }
        });
    }
    
    public int length() {
        return n;
    }

    public int index(int i) {
        return index[i];
    }
    
    /*
    public static void main(String[] args) {
        SuffixArray sa = new SuffixArray("AAA\n");
        for (int i = 0; i < sa.length(); i++ ) System.out.println(sa.index(i) );
        System.out.println();
        sa = new SuffixArray("ABRACADABRA!");
        for (int i = 0; i < sa.length(); i++ ) System.out.println(sa.index(i) );

    }
    */
}
