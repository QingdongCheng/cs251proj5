Author: Qingdong Cheng

BurrowsWheeler.java

encode():
Using a helper class SuffixArray to process the string. In the SuffixArray class, I create a integer array of length of input string. Taking advantage of cyclic property of the string, we use Arrays.sort() to sort the integer array. Then we output the index of the original string and the last character of each row of the sorted suffix array.

decode():
In the decoding method, we count the occurrence of the each character in the original string. Then we can calculate the next array using the property of the circular suffixes. At last, we output the original string using next array.

MoveToFront.java
encode():
We output the index of the current character in the alphabet. If the current position is not at the beginning, we move the character to the beginning, and we move the characters before the current character to the right by 1.


decode():
We output the character by the index we read from input, and we adjust out alphabet by moving the current character to the front and moving those before it to the right by one position respectively.