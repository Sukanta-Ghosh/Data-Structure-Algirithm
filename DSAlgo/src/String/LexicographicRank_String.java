package String;

/* Practise Link 
https://practice.geeksforgeeks.org/problems/rank-the-permutations2323/1 */

public class LexicographicRank_String {

	static final int CHAR=256;
    
    /* Time Complexity: O(n)
    Space Complexity: O(CHAR) */
    static int lexRank(String str) 
    { 
        int res = 1; 
        int n=str.length();
        int mul= factorial(n);
        
        int[] count=new int[CHAR];

        //This loop is to count the characters present in the array
        for(int i=0;i<n;i++)
            count[str.charAt(i)]++;
        //This loop is to find cumilative count which tells how many character are smaller than n th character
        for(int i=1;i<CHAR;i++)
            count[i]+=count[i-1];
        
        //This loop computing the final result
        for(int i=0;i<n-1;i++){
            mul=mul/(n-i);
            res=res+count[str.charAt(i)-1]*mul;
            for(int j=str.charAt(i);j<CHAR;j++)
                count[j]--;
        }
        return res; 
    } 

    static int factorial(int n) 
    { 
        return (n <= 1) ? 1 : n * factorial(n - 1); 
    } 
    
    public static void main(String args[]) 
    { 
        String str = "STRING"; 
        System.out.print(lexRank(str)); 
    } 
}
