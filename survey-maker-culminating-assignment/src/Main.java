// import ArrayList object from java.util
import java.util.ArrayList;
// import Scanner object
import java.util.Scanner;

/*
This class will run the codes and display collected data after prompting the user for making and completing a survey.
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        /*
        Part A: Building the Survey
         */

        //Asks the user for the name of the survey they are building, checking validity of userInput by using a method.
        String nameOfSurvey = getProperUserInput("Hello! Please name your survey: ");


        // Create surveyObject with name given by the user.
        Survey surveyOne = new Survey(nameOfSurvey);

        /*
        Initialize boolean variables which will control the while loops for "Part A: Building the Survey"
        (which remains true while user has questions to add), and for "Part B: Answering the Survey" (which
        remains true while user still wants to answer the survey they built).
        */
        boolean hasMoreQuestions = true;
        boolean isSurveyBeingAnswered = true;


        /*
        While loop for Part A. Only exits when user answers they do not want to add any more questions to the
        survey they are currently building
        */
        while (hasMoreQuestions) {
            /*
            Get the question from the user, which will be used to create any Question object regardless
            of the subclass (it is an instance of the superclass Questions). Input is validated using  a method.
            */
            String question = getProperUserInput("Enter the Question: ");

            /*
            User picks the type of question, which will dictate which subclass of Questions will be created
            (Each number is a case in this Switch method). Input is validated using a method.
             */
            int typeOfQuestion = getProperUserInput("Pick a type of question " +
                        "([1] Scale, [2] Time of Day, [3] Multiple Choice, [4] Open Answer, or [5] True or False): ",
                    1, 5);

                    /*
                    Switch method for creating Questions object of the appropriate subclass, depending on
                    the tyOfQuestion number chosen by the user.           
                     */
                    switch (typeOfQuestion)
                    {
                        // Creates ScaleQ object
                        case 1:
                            // prompt the user for scale type. Input is validated using a method.
                            int typeOfScale = getProperUserInput(
                                    "Is it [1] qualitative or [2] quantitative? ", 1, 2);

                            // prompt the user for the range of scale. Input is validated using a method.
                            int rangeOfScale = getProperUserInput("What is the range of the scale?",
                                    Integer.MIN_VALUE, Integer.MAX_VALUE);

                            // Initialize a new ScaleQ object with user inputs
                            ScaleQ scaleQuestions = new ScaleQ(question, typeOfScale, rangeOfScale, surveyOne);

                            /* If it is a quantitative scale, call method buildScale for this object, which will
                            automatically create the options ArrayList with integers starting from the startingNum.
                             */
                            if (typeOfScale == 2) {
                                // set the options for the scale
                                int startingNum = getProperUserInput("What is the starting number of the scale?", 
                                        Integer.MIN_VALUE, Integer.MAX_VALUE);
                                scaleQuestions.buildScale(startingNum);
                            }

                             /*
                             If it is a qualitative scale, build options ArrayList from here with the adjectives
                             the user inputs. This way, the inputs can be validated using the preexisting method.
                            */
                            if (typeOfScale == 1) {
                                for (int i = 0; i < rangeOfScale; i++) {
                                    // set the options for the scale
                                    String userInputForQualitativeScale = getProperUserInput(
                                            "Enter the options you would like to give the survey-taker for this scale. ");
                                    scaleQuestions.setOptions(userInputForQualitativeScale);
                                }
                            }
                            break; // to break out the switch
                        // Creates TimeOfDayQ object
                        case 2:
                            /*
                            Prompt the user for the earliest hour they want to be given as an option to the user (lower
                            bound in the hours range). Input is validated using a method.
                             */
                            int lowerLimit = getProperUserInput(
                                    "What is the lower limit of hours in the day? Please use 24h clock: ",
                                    0, 24);
                            /*
                            Prompt the user for the latest hour they want to be given as an option to the user (upper
                            bound in the hours range). Input is validated using a method.
                             */
                            int upperLimit = getProperUserInput("Now enter the upper limit, same rule: ",
                                    lowerLimit, 24);
                            // Initialize a new TimeOfDayQ object with user inputs
                            TimeOfDayQ timeOfDayQuestion = new TimeOfDayQ(question, lowerLimit, upperLimit, surveyOne);
                            break; // to break out the switch
                        // Creates MultipleChoiceQ object
                        case 3:
                            // Initialize a new MultipleChoiceQ object
                            MultipleChoiceQ two = new MultipleChoiceQ(question, surveyOne);
                            
                            // Create a temporary storage for answer options
                            ArrayList<String> options = new ArrayList<>();

                            // while loop for prompting the user
                            while (true)
                            {
                                // Prompt the user to add answer options
                                System.out.println("Please add an option:");
                                options.add(input.nextLine());

                                // for breaking out the loop
                                int x = getProperUserInput(
                                        "[1] Add more options / [2] continue to next question:",
                                        1, 2);
                                if (x == 2 )
                                {
                                    break;
                                }
                            }

                            // add the answer options into the Question object
                            two.addAnswers(options);
                            break; // to break out the switch
                        // Creates OpenAnswer object
                        case 4:
                            // Initialize a new OpenAnswer object
                            new OpenAnswer(question, surveyOne);
                            break; // to break out the switch
                        // Creates TrueOrFalseQ object
                        case 5:
                            // Initialize a new TrueOrFalseQ object
                            new TrueOrFalse(question, surveyOne);
                            break; // to break out the switch
                    }

            /*
            After a questions is created above, ask user if they want to create another question for their
            current survey. If [1]Yes, hasMoreQuestions remains true and the loop runs again; if [2]No,
            hasMoreQuestions becomes false, and the loop does not run again (in this case the survey is ready).
             */
            int userChoice = getProperUserInput(
                    "\nWould you like to add another question? ([1] Yes or [2] No)", 1,
                    2);
            if (userChoice == 2) {
                hasMoreQuestions = false;
            }
        }



        // Print out the question and options of the survey just made, for checking
        System.out.println("\n\n\n");

        // Print out the Survey Name
        System.out.println("Survey name: " + surveyOne.getSurveyName());
        System.out.println();

        for (int i = 0; i < surveyOne.getQuestionList().size(); i ++)
        {
            // Print out the Question number
            System.out.print("Question " + (i+1) + ": ");

            // Print out the Question Type, Question, Answer Options/Choices using the toString method in Question class
            System.out.println(surveyOne.getQuestionList().get(i));
            System.out.println();
        }

        for (int i = 0; i < surveyOne.getQuestionList().size(); i ++) {

            // Storing each question accessed from the question list
            Questions questionObject= surveyOne.getQuestionList().get(i);

            // set the size of the array storing the collected data
            questionObject.setDataCollected(questionObject.getOptions().size());
        }


        /*
        Part B: Answering the Survey
         */

        /* Prompts the user to answer whether they want to take the survey they just built. If [1]Yes,
        isSurveyBeingAnswered remains true and the program enters the loop where the user is prompted to answer
        the questions; if [2]No, isSurveyBeingAnswered is assigned false, and the while loop does not run (the user
        is not prompted).
         */
        int answerSurvey = getProperUserInput("Would you like to answer the survey above? [1]Yes [2]No: ",
                1, 2);
        if (answerSurvey == 2) {
            isSurveyBeingAnswered = false;
        }
        while(isSurveyBeingAnswered) {
            for (int i = 0; i < surveyOne.getQuestionList().size(); i ++)
            {
                // Storing each question accessed from the question list
                Questions questionObject= surveyOne.getQuestionList().get(i);

                // Print out the Question #
                System.out.print("Question " + (i + 1) + ": ");

                // Print out the question
                System.out.println(questionObject);


                // Storing the user inputs data by limiting the range of possible inputs to the number of answer options
                // OpenAnswer answers are stored in a separate array, since it receives string answers, while the rest receive integers
                if (questionObject.getType().equals("Open Answer")) {
                    questionObject.addOpenAnswerData(getProperUserInput("Please enter your answer. Press enter when you are done: "));
                } else {
                    int userAnswerForDataCollection = getProperUserInput("Please enter the number of your answer choice: ",
                            1, questionObject.getOptions().size());
                    System.out.println();

                    // add collected data (user input here) to dataCollected array
                    questionObject.addDataCollected(userAnswerForDataCollection - 1);
                }

            }
            // Prompts the user again, to see if they want to take the survey again.
            answerSurvey = getProperUserInput("Would you like to answer this survey again? [1]Yes [2]No: ",
                    1, 2);
            if (answerSurvey == 2) {
                isSurveyBeingAnswered = false;
            }
            System.out.println("\n");

        }


        /*
        Part C: Result Printing
         */


        /*
        Once the user is done taking the survey, the results (that is, the answers data collected from all
        the times the user took the survey, accumulated in the dataCollected array) are displayed.
         */
        System.out.println("Results are printed as the following:\n\n");
        System.out.println("Survey name: " + surveyOne.getSurveyName());



        for (int k = 0; k < surveyOne.getQuestionList().size(); k ++) {

            Questions questionOptions = surveyOne.getQuestionList().get(k);

            // Print out the Question #
            System.out.print("Question " + (k + 1) + ": ");
            System.out.println(questionOptions);
            System.out.println("Answers displayed below:");

            if (questionOptions.getType().equals("Open Answer")) {

                questionOptions.printOpenAnswerData();
            } else {
                System.out.println("(Option) : (Number of people choosing this option)");
                questionOptions.printDataCollected();
            }



        }


    }



    /**
     * Auxiliary recursive method for getProperUserInput for integers.
     * It keeps calling itself while the userInput is not an int (and thus throws an error
     * caught by the try-catch), and returns the user input when it is an int.
     * Preconditions: No parameters. getProperUserInput for integers must be called in main.
     * Post-conditions: An integer user input, no errors.
     * @return The user input which does not throw an error (for not being and integer).
     * Calls itself if an error is caught.
     */
    public static int auxiliaryValidationForInt() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        } catch (Exception e) {
            System.out.println("This input is not valid. Please enter an integer: ");
        }
        return auxiliaryValidationForInt();
    }

    /**
     * Returns a validated user input for questions requiring integer answers.
     * Preconditions: A string with the questions to be prompted to the user, and ints with the
     * lower and upper limits where the user answer should be.
     * Post-conditions: Validated integer user input, within the lower and upper limits passed in.
     * @param questionForUser- String with the questions to e prompted to the user.
     * @param lowerLimit- lowest number the user is allowed to input.
     * @param upperLimit- greatest number the user is allowed to enter.
     * @return userInput- Validated userInput, as an integer within the bounds indicated.
     */
    public static int getProperUserInput(String questionForUser, int lowerLimit, int upperLimit) {
        Scanner input = new Scanner(System.in);
        System.out.println(questionForUser);
        int userInput= auxiliaryValidationForInt();
        while (userInput < lowerLimit || userInput > upperLimit) {
            System.out.println("This input is out of bounds. Try again: ");
            userInput = auxiliaryValidationForInt();
        }
        return userInput;

    }


    public static String auxiliaryValidationForString() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (!(userInput.equalsIgnoreCase(""))) {
            return userInput;
        }
        System.out.println("This input is not valid. Please re-enter: ");
        return auxiliaryValidationForString();
    }

    /**
     * Returns a validated user input for questions requiring String answers.
     * Preconditions: A string with the questions to be prompted to the user.
     * Post-conditions: Validated String user input, which cannot be empty.
     * @param questionForUser- String with the questions to e prompted to the user.
     * @return call to the auxiliaryValidationForString method, which returns userInput
     * once it is not an empty String
     */
    public static String getProperUserInput(String questionForUser) {
        Scanner input = new Scanner(System.in);
        System.out.println(questionForUser);
        return auxiliaryValidationForString();

    }


}


