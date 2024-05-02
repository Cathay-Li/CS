// import ArrayList function from java.util
import java.util.ArrayList;

/*
This class initializes Survey object and getter methods for getting instances variables.
 */
public class Survey {

    // store the survey name
    private String nameOfSurvey;
    // store a list of questions
    static ArrayList<Questions> questions = new ArrayList<Questions> ();

    /**
     * Initializes a Survey object.
     * Preconditions: String nameOfSurvey is required as parameter.
     * Post-conditions: Survey object will be created using the String nameOfSurvey.
     *
     * @param nameOfSurvey-survey name
     */
    public Survey (String nameOfSurvey) {
        this.nameOfSurvey = nameOfSurvey;
    }

    /**
     * Returns the survey name.
     * Precondition: Survey object is initialized.
     * Post-condition: String nameOfSurvey accessed from Survey object will be returned.
     *
     * @return nameOfSurvey- survey name
     */
    public String getSurveyName()
    {
        return nameOfSurvey;
    }

    /**
     * Returns the question list.
     * Precondition: Survey object is initialized.
     * Post-condition: ArrayList<Questions> questions accessed from Survey object will be returned.
     *
     * @return questions-question list
     */
    public ArrayList<Questions> getQuestionList()
    {
        return questions;
    }


}
