/**
 * Created by Aria on 3/12/2017.
 */

public class Rectangle extends ShapeImpl {

    Rectangle(int xLocation, int yLocation, int width, int height) {
        super(xLocation, yLocation, width, height);
    }

    @Override
    protected boolean isInside(int x, int y) {
        boolean isInside = ((getLocationX() < x) && (x < (getLocationX() + getWidth() - 1))) && ((getLocationY() < y) && (x < (getLocationY() + getHeight() - 1)));
        if (isInside) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean isBorder(int x, int y) {
        boolean isXBorder = ((getLocationX() <= x) && (x <= getLocationX() + getWidth())) && ((getLocationY() == y) || (y == getLocationY() + getHeight()));
        boolean isYBorder = ((getLocationY() <= y) && (y <= getLocationY() + getHeight())) && ((getLocationX() == x) || (x == getLocationX() + getWidth()));
       boolean isStartBorder = ((x == getLocationX()) || (y == getLocationY()));

        if (isXBorder || isYBorder || isStartBorder) {
            return true;
        } else {
            return false;
        }
    }
}

