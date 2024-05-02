
// import ArrayList function from java.util
import java.util.ArrayList;

/*
This class initializes Questions object, contains setter and getter methods for instance variables and contains a
toString method.
 */

public class Questions {
    // Storing the question
    private String question;
    // Storing the question type
    private String type;
    // Storing answer options
    private ArrayList<String> options = new ArrayList<> ();
    // Storing collected data for type of questions other than Open Answer
    private int[] dataCollected;
    // Storing collected data for Open Answers
    private ArrayList<String> openAnswerData = new ArrayList<>();


    /**
     * Initialize a Questions object.
     * Preconditions: String question, String type, Survey surveyName are required as parameters.
     * Post-conditions: Questions object is initialized and added into the ArrayList<Questions> questionList in the
     * Survey object.
     *
     * @param question-String for initializing the initial variable String question in the object.
     * @param type-String for initializing the initial variable String questionType in the object.
     * @param nameOfSurvey- Questions object will be added into the questionList accessed from the Survey surveyName.
     */
    public Questions (String question, String type, Survey nameOfSurvey) {
        this.question = question;
        this.type = type;
        nameOfSurvey.questions.add(this);
    }

    /**
     * Add 1 answer choice/option to question
     * Preconditions: Questions object is initialized; String parameter is added to be the new answer choice.
     * Post-conditions: New answer choice will be added into the ArrayList<String> options in the question object.
     *
     * @param option-answer choice/option added to ArrayList<String> answer in object.
     */
    public void setOptions(String option) {
        options.add(option);
    }

    /**
     * Returns ArrayList<String> Options.
     * Preconditions: Questions object is initialized.
     * Post-conditions: ArrayList<String> options accessed from object is returned.
     *
     * @return options- ArrayList<String> storing answer choices/options in the Questions object.
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     * Returns String type.
     * Preconditions: Questions object is initialized.
     * Post-conditions: String type accessed from object is returned.
     *
     * @return type-String instance variable storing the type of question
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Set the size of int[] dataCollected
     * Preconditions: Question object is initialized. int parameter size is necessary.
     * Post-conditions: int[] dataCollected is initialized with specific size from the parameter.
     *
     * @param size- set the size of the int[]
     */
    public void setDataCollected(int size)
    {
        dataCollected = new int[size];
    }

    /**
     * Add 1 to specific index in int[] dataCollected. Each index is equivalent to an options given the user
     * for the current question.
     * Preconditions: Questions object and int[] dataCollected are initialized. Parameter int userChoice needed.
     * Post-conditions: item in int[] dataCollected accessed from the Questions object is changed.
     *
     * @param userChoice- index of item
     */
    public void addDataCollected(int userChoice) {
            dataCollected[userChoice]++;
        }

    /**
     * Print int[] options.
     * Preconditions: Questions object and int[] dataCollected are initialized.
     * Post-conditions: int[] dataCollected accessed from object is displayed.
     */
    public void printDataCollected()
    {
        // get each options from the int[]
        for (int i = 0; i < dataCollected.length; i++ )
        {
            // print each option with its corresponding choice number
            System.out.println( (options.get(i)) + ": " + dataCollected[i] + " ");
        }
        System.out.println("\n");
    }

    /**
     * Add answers to openAnswerData.
     * Preconditions: Questions object is initialized; String parameter is needed.
     * Post-conditions: String parameter is added to ArrayList<String> openAnswerData accessed from the Questions
     * object.
     *
     * @param userChoice- answer that will be added
     */
    public void addOpenAnswerData(String userChoice) {
        openAnswerData.add(userChoice);
    }

    /**
     * Print ArrayList<String> options.
     * Preconditions: Questions object is initialized.
     * Post-conditions:  ArrayList<String> openAnswerData accessed from object is displayed.
     */
    public void printOpenAnswerData()
    {
        // get each options from openAnswerData
        for (String item: openAnswerData)
        {
            // Display each option
            System.out.println(item);
        }
        System.out.println("\n");
    }


    /**
     * Returns the question and answer choices for display.
     * Preconditions: Question object is initialized.
     * Post-conditions: String questions and String objects from ArrayList<String> answerList accessed from the
     * Questions object are returned.
     *
     * @return String question and ArrayList<String> options accessed from the question object.
     */
    public String toString() {

        // Create a temporary String storage for answer options/choices
        String printOptions = "";

        switch(type) {
            // if question type is scale
            case "Scale":
                // get each answer option
                for (int i = 0; i < options.size(); i++) {
                    // store each option with its choice number horizontally
                    printOptions += "[" + (i + 1) + "]" + options.get(i) + "  ";
                }
                printOptions += "\n";
                break;

            // if question type is open answer
            case "Open Answer":
                // return type of question, question
                return type + "\nQuestion: " + question;

            // other question types
            default:
                // get each answer option
                for (int i = 1; i <= options.size(); i++)
                {
                    // store each option on a separate line with its choice number
                    printOptions += "[" + i + "] " + options.get(i-1) + "\n";
                }
                break;
        }

        // return type of question, question, and answer options
        return type + "\nQuestion: " + question + "\nOptions:\n" +  printOptions;
    }
}
