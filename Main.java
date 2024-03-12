// Programmer(s): Matthew Woodside
// Course: CS212
// Due Date: 2/1/2024
// In-class assessment: Ski Jump
// Problem Statement: This program takes the user's hill type and speed and calculates their distance travelled and total points earned 
// Data In: Hill type and user's speed
// Data Out: Their distance travelled, points earned, and a message reflecting their results
// Credits: Examples online for error checking, used as references but not exact copies

// Imports the utilities Objects and Scanner
import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {

// Initializes the variables to be used later
        double points_per_meter = 0;
        int par = 0;
        int height = 0;
        int i = 1;
        boolean counter = true;
        Double speed = null;

// Sets up the Scanner utility with the key word 'input'
        Scanner input = new Scanner(System.in);

// Sets up the Decimal Format utility
        DecimalFormat fmt = new DecimalFormat("#0.00");

// Outputs purpose of the program
        System.out.println("Welcome to the slopes! Enter your hill type and height and we'll calculate your points!");

// Asks user for the type of hill
        System.out.println("What hill type did you ride? ");

// While loop which goes until a valid hill type is entered
        while (i != 0) {
            String hill_type = input.nextLine();

// Assigns variables with their correct value based off of the hill entered
            if (Objects.equals(hill_type.toUpperCase(), "NORMAL")) {
                points_per_meter = 2;
                par = 90;
                height = 46;
                i = 0;
            } else if (Objects.equals(hill_type.toUpperCase(), "LARGE")) {
                points_per_meter = 1.8;
                par = 120;
                height = 70;
                i = 0;
            } else {
                System.out.println("There was an error in entering your hill type, please try again: ");
            }
        }

// While loop which goes until a valid speed is entered
        while (counter) {
            System.out.println("What speed were you going at the end of the ramp? ");
            String speed_string = input.nextLine();

// Try-catch used to ensure the program doesn't crash
            try {
                speed = Double.parseDouble(speed_string);

// If-statement which ensures the speed is positive
                if (speed<0){
                    System.out.println("Error: ");
                } else {
                    counter = false;
                }
            } catch (NumberFormatException ignored) {
            }
        }

// Calculates the air time, distance, and points for the user and outputs them
        double air_time = Math.sqrt(2*height/9.8);
        double distance = speed * air_time;
        double points = 60 + (distance - par)*points_per_meter;
        System.out.println("You travelled "+ fmt.format(distance)+" far!");
        System.out.println("You earned "+ fmt.format(points)+" points");

// If-statement which outputs a message reflecting the user's performance         
        if (points >= 61){
            System.out.println("Great job for doing better than par!");
        } else if (points < 10) {
            System.out.println("What happened??");
        } else {
            System.out.println("Sorry you didn't go very far");
        }
    }

    }

