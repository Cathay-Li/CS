/*
    This class creates TimeOfDayQ objects, extending the superclass Questions. Its objects contain the
 instance variables inherited from main, as well as the additional ints lowerLimit and upperLimit,
 which define the  bounds of the range of hours in the day which will e ien as answer options to the
 survey-taker. It also contains the additional method  buildSlot, which  builds the ArrayList options,
 located in Questions with the hours ien as options.
 */

public class TimeOfDayQ extends Questions{

    private int lowerLimit;
    private int upperLimit;

    /**
     * Initializes the subClass TimeOfDayQ object, which extends Questions.
     * Preconditions: String question, integers lowerLimit and upperLimit, and nameOfSurvey
     * are required as parameters.
     * Post-conditions: TimeOfDayQ object is initialized (added into the ArrayList<Questions>
     * questionList in the Survey object since it extends Questions), and the method buildTimeSlots()
     * is called.
     * @param questions- String with the questions being asked in the Survey with the TimeOfDayQ type of answer.
     * @param lowerLimit- The minimum hour slot the user will be able to pick as an answer (lower bound in the range of hours).
     * @param upperLimit- The maximum hour slot the user will be able to pick as an answer (upper bound in the range of hours).
     * @param nameOfSurvey- The name of the Survey to which this question belongs to.
     */
    public TimeOfDayQ (String questions, int lowerLimit, int upperLimit, Survey nameOfSurvey) {
        super(questions, "Time of Day", nameOfSurvey);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        buildTimeSlots();
    }

    /**
     * Builds the array of Options (located in the superclass Questions) for a timeOfDayQ question,
     * adding 1 to the lowerLimit until it reaches the upperLimit (the options given are whole hours)
     * Preconditions: TimeOfDayQ object must be initialized;
     * Post-conditions: the ArrayList options, in the superclass Questions, is custom "built" (values are added)
     * to contain the range of whole hours whose bounds are defined in here (in the current object)
     */
    public void buildTimeSlots() {
        for (int time = lowerLimit; time <= upperLimit; time += 1) {
            super.setOptions(String.valueOf(time) + "h");
        }
    }
}
