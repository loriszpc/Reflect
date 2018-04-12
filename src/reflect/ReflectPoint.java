package reflect;

import java.util.Objects;

/**
 * @author loris
 * @date 2018/4/10 21:24
 */
public class ReflectPoint {

    private int x;
    public int y;

    public String str1 = "ball";
    public String str2 = "football";
    public String str3 = "acc";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReflectPoint)) return false;
        ReflectPoint point = (ReflectPoint) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getX(), getY());
    }

    public ReflectPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
