//In this code, I  apply Insertion Sort logic 
//but instead in here, algorithm begins from the last index and goes to first index of array

import java.util.Arrays;

public class beginFromLastInsertion {
    public static void main(String[] args) {
        int array [] = {2,1,3,6,5};

        System.out.println(Arrays.toString(beginFromLastInsertion(array)));
    }

    public static int [] beginFromLastInsertion(int arr[]){
        //begin from (arr.length-1) and choose that index as a key
        for(int j=arr.length-1;j>=0;j--){
            int i = j+1;
            int key = arr[j];
            //if key value greater than rigthmost values
            //then, make swap operation
            while(i<arr.length && key>arr[i]){
                arr[i-1] = arr[i];
                i++;
            }
            //we assigned choosen key value to a variable
            //thats why in below we can easily assign a[i-1]th index to a key value
            arr[i-1] = key;
        }
        //finally return sorted array
        return arr;
    }
}