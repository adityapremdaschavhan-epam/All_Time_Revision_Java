package dsa_questions;

public class MoveAllZeros {
    public static void main(String[] args) {
        
        int[] arr = {4,1,0,3,12};

        // Brute force 
        // Create a temp array and copy all non-zero elements in front and then zero to last

        // int temp[] = new int[arr.length];
        // int j=0;
        
        // for(int i=0;i<arr.length;i++)
        // {
        //     if(arr[i]!=0)
        //     {
        //         temp[j++]=arr[i];
        //     }
        // }

        // // copy it back to arr
        // for(int i=0;i<temp.length;i++)
        // {
        //     arr[i]=temp[i];
        // }
        // for(int num: arr){
        //     System.out.print(num+" ");
        // }

        // Two pointer 
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                
                j++;
            }
            
        }
        for(int num : arr){
            System.out.print(num + " ");
         }
        

    }
    
}
