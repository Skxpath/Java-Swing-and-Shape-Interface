import java.util.ArrayList;

/**
 * TextBox class which creates
 * a Rectangle with text inside it.
 */
public class TextBox extends Rectangle {

    private final int maxCharArraySize = getWidth() - 2;
    private String message;
    private char[] charArray;
    private ArrayList<String> stringList = new ArrayList<>();
    private ArrayList<char[]> charList = new ArrayList<>();
    private int maxMessageLength;

    TextBox(int xLocation, int yLocation, int width, int height, String message) {
        super(xLocation, yLocation, width, height);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void draw(Canvas canvas) {

        drawPreparation();
        drawCanvas(canvas);
        printTextCanvas(canvas);
        drawBorder(canvas);

    }

    //Prepares to draw on a canvas
    private void drawPreparation() {
        charArray = message.toCharArray();
        this.maxMessageLength = charArray.length - 1;
        calculateStrings();
        generatePrintableArrays();
    }

    //Prints text on the canvas
    private void printTextCanvas(Canvas canvas) {

        int i = 0;
        int j = 0;

        for (int y = getLocationY() + 1; y <= getLocationY() + getHeight() + 1; y++) {
            for (int x = getLocationX() + 1; x <= getLocationX() + getWidth() - 1; x++) {
                if (isInside(x, y)) {
                    canvas.setPointText(x, y, charList.get(i)[j]);
                }
                if (j + 1 < charList.get(i).length)
                    j++;
            }
            if (i + 1 < charList.size()) {
                i++;
            }
            j = 0;
        }
    }

//Generates the character arrays necessary to print on the canvas
    private void generatePrintableArrays() {
        double startingPoint;
        int castStartingPoint;
        int stringLength;
        String msgString;

        for (int i = 0; i < stringList.size(); i++) {

            msgString = stringList.get(i).trim();
            stringLength = msgString.length();

            startingPoint = (maxCharArraySize - stringLength) / 2;
            castStartingPoint = (int) startingPoint;

            char[] tempStringArray = stringList.get(i).toCharArray();
            char[] tempCharArray = new char[maxCharArraySize];
            int k = 0;

            for (int j = castStartingPoint; j < maxCharArraySize; j++) {
                tempCharArray[j] = tempStringArray[k];
                k++;
            }
            charList.add(tempCharArray);
        }
    }

    //Calculates the strings to be printed on each row of the shape.
    private void calculateStrings() {
        int lastCriticalIndex = 0;
        int currentIndex = lastCriticalIndex;
        int newInitialIndex = 0;


        for (int y = 1; y < getHeight() - 1; y++) {

            //Checks if a string reached the end of the line from the start and still has no spaces (criticalIndexes)
            boolean endOfLineNoSpaces = false;
            char[] tempArray = new char[maxCharArraySize];

            //Tells how long the string is to be written
            int trackerIndex;

            for (int i = 0; i < maxCharArraySize; i++) {
                if (currentIndex < charArray.length) {
                    if (charArray[currentIndex] == ' ') {
                        lastCriticalIndex = currentIndex;
                    }
                    if (i == maxMessageLength) {
                        lastCriticalIndex = maxMessageLength;
                    }
                    if ((i == maxCharArraySize - 1) && (lastCriticalIndex < newInitialIndex)) {
                        lastCriticalIndex = newInitialIndex;
                        endOfLineNoSpaces = true;
                    }
                    currentIndex++;
                } else {
                    lastCriticalIndex = maxMessageLength;
                }
            }

            if (!endOfLineNoSpaces) {
                trackerIndex = lastCriticalIndex - newInitialIndex;
            } else {
                trackerIndex = maxCharArraySize - 1;
            }


            for (int j = 0; j <= trackerIndex; j++) {
                if (newInitialIndex < charArray.length) {
                    tempArray[j] = charArray[newInitialIndex];
                    newInitialIndex++;
                }
            }

            String tempString = new String(tempArray);

            stringList.add(tempString);
            currentIndex = lastCriticalIndex + 1;
            if (endOfLineNoSpaces) {
                currentIndex = lastCriticalIndex + maxCharArraySize;
            }

            newInitialIndex = currentIndex;

        }
    }
}