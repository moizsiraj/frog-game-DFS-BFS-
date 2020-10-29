package Q2;

public class frog implements Cloneable{
    char name;
    char leftOrRight;
    boolean canHop;
    boolean canSlide;

    boolean canMove(){
        return canSlide || canHop;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
