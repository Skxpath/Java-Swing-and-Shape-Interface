import javax.swing.*;
import java.awt.*;

/**
 * Created by Aria on 3/12/2017.
 */
public class PicturePanel extends JPanel {

    private String text;
    private int width;
    private int height;

 private JLabel headerLabel;
    private JLabel canvasLabel;

   public PicturePanel (String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;

       char[] charArray = text.toCharArray();
       Canvas canvas = new Canvas(width, height);
       CanvasIcon cIcon = new CanvasIcon(canvas);

       headerLabel = new JLabel(text, JLabel.CENTER);
       canvasLabel = new JLabel(cIcon, JLabel.CENTER);

       setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
add(headerLabel);
add(canvasLabel);

    }

    public void addFront(Shape shape) {

    }

    public void addBack(Shape shape) {

    }

}
