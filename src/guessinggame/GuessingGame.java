package guessinggame;
//Java game “Guess a Number” that allows user to guess a random number that has been generated
import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null,
                    "Enter a number between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count));
            count++;
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is outside the numbers range!";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses made: " + count;
        }
        else if (userAnswer > computerNumber) {
            if (userAnswer - computerNumber == 3){
                return "You are close!\nTry number: " + (userAnswer - 1);
            }
            else {
                return "The number is too high, try again.\nTry Number: " + (userAnswer - (int) (Math.random() * 5 + 1));
            }
        }
        else if (userAnswer < computerNumber) {
            if (computerNumber - userAnswer == 3){
                return "You are close!\nTry number: " + (userAnswer + 1);
            }
            else {
                return "The number is too low, try again.\nTry Number: " + (userAnswer + (int) (Math.random() * 5 + 1));
            }
        }
        else {
            return "Your guess is incorrect!\nTry Number: " + count;
        }
    }
}