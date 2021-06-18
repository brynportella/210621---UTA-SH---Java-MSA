package main;

public class QuizQuestionExample{

    public void myMethod(){
        throw new RuntimeException(); 
    }

    public static void main(String[] args){
        try{
            QuizQuestionExample ex = new QuizQuestionExample(); 
            ex.myMethod(); 

        }finally{
            System.out.print("C "); 
        }
        System.out.print("B "); 
    }

}
