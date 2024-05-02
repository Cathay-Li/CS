/*
This class initializes TruOrFalseQ object, extends Questions, and a setter method for setting answer list in the super
class.
 */
public class TrueOrFalse extends Questions{

    /**
     * Creating a TrueOrFalseQ object.
     * Preconditions: A String and a Survey parameter is needed.
     * Post-conditions: TrueOrFalseQ object is created by passing the String question and Survey surveyName parameters
     * into the super class constructor.
     *
     * @param question-String object that contains the question
     * @param survey- Survey object where this object will be stored
     */
    public TrueOrFalse(String question, Survey survey)
    {
        super(question, "True of False", survey);
        super.setOptions("True");
        super.setOptions("False");
    }





}
