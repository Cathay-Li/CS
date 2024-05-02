// import Everything from java.util for later use
import java.util. *;

/*
This class initializes MultipleChoiceQ object, extends Questions class, and a setter method for setting answer list in
the super class.
 */
public class MultipleChoiceQ extends Questions{

    /**
     * Creating a MultipleChoiceQ object.
     * Preconditions: A String and a Survey parameter is needed.
     * Post-conditions: MultipleChoiceQ object is created by passing the String question and Survey surveyName
     * parameters into the super class constructor.
     *
     * @param question-String object that contains the question
     * @param surveyName- Survey object where this object will be stored
     */
    public MultipleChoiceQ(String question, Survey surveyName)
    {
        super(question, "Multiple Choice", surveyName);
    }


    /**
     * Add answer choices to multiple choice question
     * Preconditions: MultipleChoiceQ object extends Questions is initialized.
     * Post-conditions: New answer choice will be added into the ArrayList<String> options accessed in the question
     * object.
     *
     * @param answers- List of answer options that will be passed into the ArrayList<String>
     */
    public void addAnswers(ArrayList<String> answers)
    {
        // Using the method from Questions class to store the answer choices accessed from answers
        for (String item:answers)
        {
            super.setOptions(item);
        }
    }
}
