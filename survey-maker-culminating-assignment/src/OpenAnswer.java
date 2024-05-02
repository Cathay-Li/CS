/*
This class initializes OpenAnswer object, extends Questions class.
 */
public class OpenAnswer extends Questions{
    /**
     * Creating a OpenAnswer object.
     * Preconditions: A String and a Survey parameter is needed.
     * Post-conditions: OpenAnswer object is created by passing the String question and Survey surveyName parameters
     * into the super class constructor.
     *
     * @param question-String object that contains the question
     * @param survey- Survey object where this object will be stored
     */
    public OpenAnswer(String question, Survey survey)
    {
        super(question, "Open Answer", survey);
    }

}
