package hw4;

import java.util.Objects;

public class Box {
    private int w;
    private int p;

    public Box(int w, int p) {
        this.w = w;
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return w == box.w &&
                p == box.p;
    }

    @Override
    public int hashCode() {
        return Objects.hash(w, p);
    }

    @Override
    public String toString() {
        return "Box{" +
                "w=" + w +
                ", p=" + p +
                '}';
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}
