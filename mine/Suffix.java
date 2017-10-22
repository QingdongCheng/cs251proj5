public class Suffix {
    private static final int CUTOFF = 15;
    private int[] index;
    private int n;
    
    public Suffix(String str){
        n = str.length();
        index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        sortSuffix(str, 0 , n - 1, 0);
    
    }
    
    public int length() {
        return n;
    }
    
    
    public int index(int i) {
        return index[i];
    }
    
    
    private char charAt(String str, int suffix, int offset) {
        return str.charAt((suffix + offset) % n);
    
    
    }

    private void sortSuffix(String str, int low, int hi, int offset) {
        if (hi - low <= CUTOFF) {
            insertion(str, low, hi, offset);
            return;
        }
        
        int lt = low, gt = hi, piv = charAt(str, index[low], offset), eq = low + 1;
        
        while (eq <= gt) {
            int temp = charAt(str, index[eq], offset);
            if (temp < piv) {
                exch(lt++, eq++);
            } else if (temp > piv) {
                exch(eq, gt--);
            } else {
                eq++;
            }
            sortSuffix(str, low, lt - 1, offset);
            
            if (piv >= 0)
                sortSuffix(str, lt, gt, offset + 1);
            sortSuffix(str, gt + 1, hi, offset);
        
        }
        
    
    }
    
    private void exch(int i, int j) {
        
        int temp = index[i];
        index[i] = index[j];
        index[j] = temp;
        
    }
    
    
    private void insertion(String s, int lo, int hi, int offset) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(s, j, j- 1, offset); j--){
                exch(j, j -1);
            }
        }
        
    }

    
    private boolean less(String s, int i , int j, int offset) {
        int oi = index[i], oj = index[j];
        
        for (; offset < n; offset++) {
            int ival = charAt(s, oi, offset), jval = charAt(s, oj, offset);
            if (ival < jval) return true;
            else if (ival > jval) return false;
            
        }
        
        return false;
        
    }


}
