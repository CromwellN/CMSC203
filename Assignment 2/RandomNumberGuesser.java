/**
 * Class: CMSC203 
 *  Program: Assignment # 2
 *  Instructor: Dr. Grinberg
 * Description: This program ask the user to guess a number between 0-100.
 * Due: 09/27/2020
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Cromwell Nzouakeu
*/

import java.util.Scanner;
public class RandomNumberGuesser {
	public static void main(String[] args) {
        
		Scanner userInput = new Scanner(System.in);
		int randNum = 0;
        int nextGuess = 0;
        int lowGuess = 0;
        int highGuess = 0;
        int firstGuess = 0;
        int loop = 0;
        // generate a random number
        // Print highGuess and lowGuess 
        do {
            loop = 0;
           if (firstGuess == 0) {
                randNum = RNG.rand();
                highGuess = 100;
                lowGuess = 0;
                System.out.println("Enter your first guess");
                nextGuess = Integer.parseInt(userInput.nextLine());    
              //check if firstGuess is equal to randomly generated number
              //if not then we also check if the guess is too high or too low
                if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                    System.out.println("Number of Guess is " + RNG.getCount());
                    if (nextGuess > randNum) {
                        System.out.println("You Guess is too High ");
                        highGuess = nextGuess;
                    } else if (nextGuess < randNum) {
                        System.out.println("Your Guess is too Low ");
                        lowGuess = nextGuess;
                    } else if (nextGuess == randNum) {
                        loop = 1;
                    }
                }
                firstGuess = 1;
            } 
           else {
                //loop to check if the guess is equal to randomly generated number
                do {
                    System.out.println("Enter your guess between " + lowGuess + " and " + highGuess);
                    nextGuess = Integer.parseInt(userInput.nextLine());
                    if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
                        System.out.println("Number of guessses is " + RNG.getCount());             
                        if (nextGuess > randNum) {
                            System.out.println("Your guess is too high");
                            highGuess = nextGuess;
                        } else if (nextGuess < randNum) {
                            System.out.println("Your guess is too low");
                            lowGuess = nextGuess;
                        } else if (nextGuess == randNum) {
                            loop = 1;
                            break;
                        }
                    }
                } while (true);
            }
            //if the user guessed the number
            if (loop == 1) {
                System.out.println("Congratulations, you guessed correctly.");
                int exit = 0;
                //Check if the user want to play again 
                do {
                    System.out.println("Try again? (yes or no)");
                    String choice = userInput.nextLine();
                    if(choice.equalsIgnoreCase("yes")){
                        RNG.resetCount();
                        firstGuess = 0;
                        break;
                    }else if(choice.equalsIgnoreCase("no")){
                        exit = 1;
                        break;
                    }
                } while (true);
                if(exit==1){
                    break;
                }
            }
        } while (true);
        System.out.println("Thank you playing.");
    }
}