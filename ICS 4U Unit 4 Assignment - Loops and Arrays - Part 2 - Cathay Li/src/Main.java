//level 3

//This program will count the number of all possible hits of Infinity the Game for given dice numbers and target
//This program will prompt the user for number of attacker dice, number of defender dice, attacker target and defender
//target.
//This program will count and display the number of all possible ways to do specific number of hits in each round.

//import Scanner module
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        hits();
    }

    //This static void method takes not parameters and will prompt the user for information,
    //calculate the number of hits, and display the results
    public static void hits()
    {
        //Rules
        System.out.println("\nHere is the rules for this program:");
        System.out.println("This program calculates all possible number of hits from attacker to defender dice " +
                "(20 sided die).");
        System.out.println("\nA hit is defined by: (1a 1b must be met at the same time or 2 is met)");
        System.out.println("\t1a. attacker dice <= attacker target");
        System.out.println("\t1b. attacker dice is greater than all defender dices that is <= defender target");
        System.out.println("\t2. defender dice > defender target");

        //Prompt the user section
        //create new Scanner object
        Scanner input = new Scanner(System.in);

        //prompt the user for attacker dice number
        System.out.println("Number of dice for Attacker:");

        //store the attacker dice number in an int
        int attackDice = input.nextInt();

        input.nextLine(); //to avoid error

        //prompt the user for attacker target
        System.out.println("Attack Target (1-20):");

        //store the defender target in an int
        int attackTar = input.nextInt();

        input.nextLine(); //to avoid error



        System.out.println(); //extra space line



        //prompt the user for defender dice number
        System.out.println("Number of dice for Defender:");

        //store the attacker dice number in an int
        int defenceDice = input.nextInt();

        input.nextLine(); //to avoid error

        //prompt the user for defence target
        System.out.println("Defense Target (1-20):");

        //store the defender target in an int
        int defenceTar = input.nextInt();

        System.out.println(); //extra space line


        //Calculation Section

        int[] defender = new int[defenceDice]; //defender dices

        int[] attacker = new int[attackDice]; //attacker dices

        int[] hitsArray = new int[attackDice + 1]; //hit numbers (ex. index 0 = number of 0 hits)

        int fakeHit = 0; //the number of 1 attacker dice hit(greater than) 1 defender dice

        int hit = 0; //the number of hits per round

        //initialize all items in the defender array to be 1
        for (int i = 0; i < defender.length; i++) {
            defender[i] = 1;
        }



        //Defender Dice Section
        //roll all defender dices from 1 to 20
        for (int i = 1; i <= 21; i++) //i = number on dice
        {
            defender[defender.length - 1] = i; //let the last item (a die) in the defender array to roll from 1 to 20

            //search up for 21 in defender dices from backwards
            for (int k = defender.length - 1; k >= 0; k--) //k is an index
            {
                //suppose that the defender array is a base 20 number, each item in the array is a digit
                //if a digit goes to 21
                if (defender[0] != 21) //to avoid ArrayIndexOutOfBoundsException
                {
                    if (defender[k] == 21) {
                        defender[k - 1] += 1; //the digit before it increase by 1
                        defender[k] = 1; //the digit itself goes back to 1

                    }
                }
            }

            //to avoid the last loop for defender dice
            if (defender[0] < 21) {


                //initialize and reset all items in the attacker array to be 1
                for (int l = 0; l < attacker.length; l++) {
                    attacker[l] = 1;
                }


                //Attacker Dice Section
                //roll all attacker dices from 1 to 20
                for (int x = 1; x <= 21; x++) //x = number on dice
                {
                    attacker[attacker.length - 1] = x; //let the last item (a die) in the attacker array to roll from 1 to 20

                    //search up for 21 in attacker dices from backwards
                    for (int y = attacker.length - 1; y >= 0; y--) //y is an index
                    {
                        //suppose that the attacker array is a base 20 number, each item in the array is a digit
                        //if a digit goes to 21
                        if (attacker[0] != 21) //to avoid ArrayIndexOutOfBoundsException
                        {
                            if (attacker[y] == 21)
                            {
                                attacker[y - 1] += 1; //the digit before it increase by 1
                                attacker[y] = 1; //the digit itself goes back to 1
                            }
                        }
                    }





                   /* //Test Area
                    if (attacker[0] < 21) {
                        for (int m = 0; m < attacker.length; m++) {
                            System.out.print(attacker[m] + " ");
                        }
                    }

                    System.out.println("b"); */





                    //to avoid the last loop for attacker dice
                    if (attacker[0] < 21) {

                        //Comparison Section
                        //Compare each in boundary attacker dice to all defender dice
                        for (int attack : attacker)  //go through all attacker dice
                        {
                            for (int defend : defender) //go through all defender dice
                            {
                                //compare 1 attacker die to all defender dice
                                if (defend > defenceTar) //if defender dice is out of boundary
                                {
                                    if (attack <= attackTar) //if attacker dice is in boundary
                                    {
                                        fakeHit++; //1 fake hit for the attacker
                                    }
                                }
                                //if an in-boundary attacker dice hit an in-boundary defender die
                                else if (attack <= attackTar && attack > defend)
                                {
                                    fakeHit++; // 1 fake hit for the attacker
                                }

                            }
                            //if the single attacker die hits all defender dice
                            if (fakeHit == defenceDice)
                            {
                                hit++; //it hits

                            }
                            //reset fakeHit
                            fakeHit = 0;
                        }

                        //increase the specific hit number by 1
                        //(ex. if this round got 0 hits, hit = 0; 0hit (index 0 of array hits) will increase by 1
                        hitsArray[hit]++;

                        hit = 0; //reset hit
                    }


                    //make the dice rotate from 1 to 20 infinitely
                    if (x == 21) {
                        x = 1;
                    }
                    //if all digits (item in the defender array) become 20
                    if (attacker[0] == 21) {
                        x = 22; //stop the loop
                    }










                }
            }

           /* //Test Area
            if (defender[0] < 21) {
                for (int j = 0; j < defender.length; j++) {
                    System.out.print(defender[j] + " ");
                }
            }

            System.out.println("a");

            */


            //Defender Dice Section Continued
            //make the dice rotate from 1 to 20 infinitely
            if (i == 21) {
                i = 1;
            }
            //if all digits (item in the defender array) become 20
            if (defender[0] == 21) {
                i = 22; //stop the loop
            }

        }


        //Display Section
        for (int p = 0; p < hitsArray.length ; p++)
        {
            System.out.println( p + " hit(s): "  + hitsArray[p]);
        }

    }
}
