/**
 * Created by Aria on 3/14/2017.
 */

public class Triangle extends ShapeImpl {


   Triangle(int xLocation, int yLocation, int size) {
    super(xLocation, yLocation, size);
    }

    @Override
    protected boolean isInside(int x, int y) {
        return true;
    }

    @Override
    protected boolean isBorder(int x, int y) {

        boolean xBoundary = (getLocationX() <= x) && (x <= getLocationX() + getSize());
        boolean yBoundary = (getLocationY() <= y) && (y <= getLocationY() + getSize());

        boolean isLeftYBorder = (yBoundary) && ((getLocationX() == x) || (x == getLocationX() + getSize()));
        boolean isBottomXBorder = (xBoundary) && (y == (getLocationY() + getSize() - 1));

        if (isLeftYBorder || isBottomXBorder) {
            return true;
        } else {
            return false;
        }
    }

}
