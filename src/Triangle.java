/**
 * Created by Aria on 3/14/2017.
 */

public class Triangle extends ShapeImpl {

   Triangle(int xLocation, int yLocation, int size) {
    super(xLocation, yLocation, size, size);
    }

    @Override
    protected boolean isInside(int x, int y) {

        boolean isInside = ((getLocationX() < x) && (x < (getLocationX()+getWidth()))) && ((getLocationY() < y) && (y < (getLocationY()+getHeight())))
                && (((x-getLocationX() < y-getLocationY())));
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

        boolean isBottomXBorder = (xBoundary) && (y == (getLocationY() + getHeight() - 1));
        boolean isLeftYBorder = (yBoundary) && ((getLocationX() == x) || (x == getLocationX() + getWidth()));

        boolean isHypotenuse = (x-getLocationX() == y-getLocationY());


        if (isLeftYBorder || isBottomXBorder || isHypotenuse) {
            return true;
        } else {
            return false;
        }
    }

}
