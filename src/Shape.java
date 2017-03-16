import java.awt.*;

/**
 * Shape interface
 */
interface Shape {
    int getLocationX();
    int getLocationY();
    void setBorderChar(char borderChar);
    char getBorderChar();
    void setColor(Color color);
    Color getColor();
    void draw(Canvas canvas);
}
