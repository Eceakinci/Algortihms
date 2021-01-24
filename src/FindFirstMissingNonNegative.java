/**Date: 04/01/2021
 * @author:EceAkinci
 * Algorithms: Hw Two Questions
 *              Question1
 * */
import java.util.Scanner;
//For implement O(logn) time, I create binary search like algorithm.
//It helps us to divide a sequence from the midpoint
//Sequence must start at 1, not 0
public class FindFirstMissingNonNegative {
    public static int findFirstMissingNonNeg(int [] arr, int start, int end){

        //if start index greater or equal to end index, then return end+1
        if(start >= end){
            return end + 1;
        }
        //if start+1 not equal to it's indexed number, then that integer is missing
        // (it is 'start+1' because our integers starting from 1, not 0. If it starts from 0 then no +1 needed)
        if(start+1 != arr[start]){
            return start + 1;
        }

        //'mid' variable helps us to divide sequence from it's midpoint
        int mid = (start + end) / 2;

        //if 'mid+1' not equal to it's indexed number, then we should look at the first half of the sequence for find the first missing
        if(mid+1 != arr[mid]){
            return findFirstMissingNonNeg(arr, start, mid);
        }
        //if mid+1 equal to it's indexed number, then we know that there is no missing in the first half, so we should look at the second half
        //of the sequence
        return findFirstMissingNonNeg(arr, mid+1, end);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array lenght: " );
        int n = input.nextInt();
        System.out.println("Enter elements one by one: ");
        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Missing element in array is " + findFirstMissingNonNeg(arr,0,n-1));
    }
}
