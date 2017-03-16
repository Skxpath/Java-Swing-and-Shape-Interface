import java.awt.*;

public abstract class ShapeImpl implements Shape {

    private final int xLocation;
    private final int yLocation;
    private final int width;
    private final int height;
    private char borderChar;
    private Color color;

    ShapeImpl(int xLocation, int yLocation, int width, int height) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.width = width;
        this.height = height;
        this.color = Color.YELLOW;
        this.borderChar = '*';
    }

    public char getBorderChar() {
        return borderChar;
    }

    public void setBorderChar(char borderChar) {
        this.borderChar = borderChar;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLocationX() {
        return this.xLocation;
    }

    public int getLocationY() {
        return this.yLocation;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    public void draw(Canvas canvas) {

        //General cases
        drawCanvas(canvas);

    }

    protected void drawCanvas(Canvas canvas) {
        for (int x = getLocationX(); x <= getLocationX()+getWidth()-1; x++) {
            for (int y = getLocationY(); y <= getLocationY()+getHeight()-1; y++) {
                if (isBorder(x, y)) {
                    canvas.setPointColor(x, y, getColor());
                    canvas.setPointText(x, y, getBorderChar());
                } else if (isInside(x, y)) {
                    canvas.setPointColor(x, y, getColor());
                    canvas.setPointText(x, y, ' ');
                }
            }
        }
    }

    protected abstract boolean isInside(int x, int y);

    protected abstract boolean isBorder(int x, int y);

}
