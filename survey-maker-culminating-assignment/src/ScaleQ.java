/*
        This class creates ScaleQ objects, extending the superclass Questions. Its objects contain the
    instance variables inherited from main, as well as the additional ints typeOfScale and rangeOfScale,
    which define characteristics of the options ArrayList specific to ScaleQ objects. It aso contains the
    additional method buildSlot, which builds the ArrayList options located in Questions, with the numbers
    in the scale which will be given the survey-taker.
 */

public class ScaleQ extends Questions{

    private int typeOfScale;
    private int rangeOfScale;

    /**
     * Initializes the subClass ScaleQ object, which extends Questions.
     * Preconditions: String question, integers typeOfScale and rangeOfScale, and nameOfSurvey
     * are required as parameters.
     * Post-conditions: ScaleQ object is initialized (and added into the ArrayList<Questions>
     * questionList in the Survey object since it extends Questions).
     * @param question- String with the questions being asked in the Survey with the ScaleQ type of answer.
     * @param typeOfScale- The type of scale, which can be either 1-qualitative or 2-quantitative.
     * @param rangeOfScale- The range of the scale, how many numbers/adjectives will be given as answer options for the user
     * @param nameOfSurvey- The name of the Survey to which this question belongs to.
     */
    public ScaleQ (String question, int typeOfScale, int rangeOfScale, Survey nameOfSurvey){
        super(question, "Scale", nameOfSurvey);
        this.typeOfScale = typeOfScale;
        this.rangeOfScale = rangeOfScale;
    }

    /**
     * Builds the array of Options (located in the superclass Questions) for quantitative ScaleQ
     * questions only (qualitative options are added from Main, to facilitate validation of user input)
     * Preconditions: ScaleQ object must be initialized, and int value startingNum must be passed in.
     * Post-conditions: the ArrayList options, in the superclass Questions, is custom "built"
     * @param startingNum- The starting number of the scale which will be displayed to the user.
     */
    public void buildScale(int startingNum) {
            for (int i = 0; i < rangeOfScale; i++) {
                if(typeOfScale == 2) {
                    super.setOptions(String.valueOf(i + startingNum));
                }
            }
    }

}

