/**
 * Rectangle class which
 * contains code to
 * draw a rectangle
 */

public class Rectangle extends ShapeImpl {

    Rectangle(int xLocation, int yLocation, int width, int height) {
        super(xLocation, yLocation, width, height);
    }

    @Override
    protected boolean isInside(int x, int y) {
        boolean isInside = ((getLocationX() < x) && (x < (getLocationX() + getWidth() - 1))) && ((getLocationY() < y) && (y < (getLocationY() + getHeight() - 1)));
        if (isInside) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected boolean isBorder(int x, int y) {
        boolean xBoundary = (getLocationX() <= x) && (x <= getLocationX() + getWidth());
        boolean yBoundary = (getLocationY() <= y) && (y <= getLocationY() + getHeight());

        boolean isTopXBorder = (xBoundary) && ((getLocationY() == y) || (y == getLocationY() + getHeight()));
        boolean isLeftYBorder = (yBoundary) && ((getLocationX() == x) || (x == getLocationX() + getWidth()));
        boolean isBottomXBorder = (xBoundary) && (y == (getLocationY() + getHeight() - 1));
        boolean isRightYBorder = (yBoundary) && (x == (getLocationX() + getWidth() - 1));

        if (isTopXBorder || isLeftYBorder || isBottomXBorder || isRightYBorder) {
            return true;
        } else {
            return false;
        }
    }
}

