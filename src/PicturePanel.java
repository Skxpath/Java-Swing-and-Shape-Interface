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
private Canvas canvas;

   public PicturePanel (String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;

        this.setLayout(new BorderLayout());

       char[] charArray = text.toCharArray();

       canvas = new Canvas(width, height);

     /*  Rectangle r1 = new Rectangle(1, 1, 4, 4);;
       r1.setColor(Color.MAGENTA);
       r1.draw(canvas);*/

       CanvasIcon cIcon = new CanvasIcon(canvas);

       headerLabel = new JLabel(text);
       canvasLabel = new JLabel(cIcon);

       this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

add(headerLabel,BorderLayout.NORTH);
add(canvasLabel);

    }

    public void addFront(Shape shape) {
shape.draw(canvas);
    }

    public void addBack(Shape shape) {

    }

}
