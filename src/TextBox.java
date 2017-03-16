import java.util.ArrayList;

/**
 * Created by Aria on 3/14/2017.
 */
public class TextBox extends Rectangle {

    private String message;
    private char[] charArray;
    private ArrayList<String> stringList = new ArrayList<>();

    TextBox(int xLocation, int yLocation, int width, int height, String message) {
        super(xLocation, yLocation, width, height);
        this.message = message;
        charArray = message.toCharArray();

        calculateStrings();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
        charArray = message.toCharArray();

    }

    @Override
    public void draw(Canvas canvas) {

        drawCanvas(canvas);

    }

    private void calculateStrings() {
        int lastCriticalIndex = 0;
        int currentIndex = lastCriticalIndex;
        int newInitialIndex = 0;
        final int maxMessageLength = charArray.length - 1;
        final int maxCharArraySize = getWidth() - 2;


        for (int y = 1; y < getHeight() - 1; y++) {

boolean var = false;
            for (int i = 0; i < maxCharArraySize; i++) {



                if (currentIndex < charArray.length) {
                    if (charArray[currentIndex] == ' ') {
                        lastCriticalIndex = currentIndex;
                        System.out.println("Current crit index = " + lastCriticalIndex);
                    }
                    if (i == maxMessageLength) {
                        lastCriticalIndex = maxMessageLength;
                       System.out.println("Current crit index overridemaxmessagelength = " + lastCriticalIndex);
                    }
                    if ((i == maxCharArraySize-1)&&(lastCriticalIndex < newInitialIndex)) {
                        lastCriticalIndex = newInitialIndex;
                        System.out.println("Current crit index override case = " + lastCriticalIndex);
                        var = true;
                    }
                    currentIndex++;
                    System.out.println(currentIndex);
                } else {
                    System.out.println("reached max length at i: " + i + " and length: " + message.length());
                    lastCriticalIndex = maxMessageLength;
                }
            }

            char[] tempArray = new char[maxCharArraySize];
            int trackerIndex;
            if (!var) {
                trackerIndex = lastCriticalIndex - newInitialIndex;
                System.out.println("Current tracker index: " + trackerIndex);
            } else {
                trackerIndex = maxCharArraySize-1;
                System.out.println("Current tracker index override: " + trackerIndex);
            }

            System.out.println("Current tracker index and initialindex before printing " + trackerIndex + " and " + newInitialIndex);

            for (int j = 0; j <= trackerIndex; j++) {
                if (newInitialIndex < charArray.length) {
                    tempArray[j] = charArray[newInitialIndex];
                    newInitialIndex++;
                }
            }
            String tempString = new String(tempArray);
            System.out.println(tempString);
            stringList.add(tempString);
            currentIndex = lastCriticalIndex + 1;
            if (var) {
                currentIndex = lastCriticalIndex+maxCharArraySize;
            }
            newInitialIndex = currentIndex;

        }

        System.out.println(message.length());
    }
}