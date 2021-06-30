import java.util.Arrays; 

public class ExerciseSolution {
    public static void main(String[] args){
        /*
        1. Create a while loop that stores the numbers one through fifty in an array.
        */
        int[] arrayOfNumbers = new int[50]; 
        int counter = 1; 
        int index = 0; 

        while(index < arrayOfNumbers.length){
            arrayOfNumbers[index] = counter; 
            index++; //2
            counter++; //3
        }
        System.out.println(Arrays.toString(arrayOfNumbers)); 

        /*
        *2. Use a do while loop to add five to all the odd numbers in the array.
        */
        index = 0;
        do{
            //get the element in our array
            int currentElement = arrayOfNumbers[index]; 
            //check if it's odd
            if(currentElement % 2 != 0){
                //add five to it if it is
                arrayOfNumbers[index] = currentElement + 5;
            }
            index++; 
            
        }while(index < arrayOfNumbers.length);
        System.out.println(Arrays.toString(arrayOfNumbers)); 
    
    /*
    * Use a for loop to print each element of the array. Unless that element is a multiple of four or six. If it's a multiple of four print FOUR!!. If it's a multiple of six print SIX!!!. If it's a multiple of both print FOUR!!SIX!!!. 
    */
    for(int i = 0; i<arrayOfNumbers.length; i++){
        int currentElement = arrayOfNumbers[i]; 
        if(currentElement % 4 == 0 && currentElement % 6 ==0)
            System.out.println("FOUR!!SIX!!!");
        else if (currentElement % 4 == 0)
            System.out.println("FOUR!!");
        else if (currentElement % 6 ==0)
            System.out.println("SIX!!!");
        else
            System.out.println(currentElement);
    }
    
}

}
