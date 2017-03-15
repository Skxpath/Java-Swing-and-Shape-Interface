import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Aria on 3/12/2017.
 */
public class PicturePanel extends JPanel {


    private Canvas canvas;
    private ArrayList<Shape> shapeList = new ArrayList<>();

    public PicturePanel(String text, int width, int height) {

        JLabel headerLabel;
        JLabel canvasLabel;

        this.setLayout(new BorderLayout());

        // char[] charArray = text.toCharArray();

        canvas = new Canvas(width, height);

        CanvasIcon cIcon = new CanvasIcon(canvas);

        headerLabel = new JLabel(text);
        canvasLabel = new JLabel(cIcon);

        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        add(headerLabel, BorderLayout.NORTH);
        add(canvasLabel);

    }

    public void addFront(Shape shape) {
        shapeList.add(shape);

        drawShapes();
    }


    public void addBack(Shape shape) {
        shapeList.add(0, shape);

        drawShapes();
    }

    private void drawShapes() {
        for (Shape s : shapeList) {
            s.draw(canvas);
        }
    }

}
