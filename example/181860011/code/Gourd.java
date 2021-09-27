package code;

import java.util.*;

import code.Line.Position;

public class Gourd implements Linable {

    // ONE(204, 0, 0),

    // TWO(255, 165, 0),

    // THREE(252, 233, 79),

    // FOUR(78, 154, 6),

    // FIVE(50, 175, 255),

    // SIX(114, 159, 207),

    // SEVEN(173, 127, 168);

    private final int r;
    private final int g;
    private final int b;
    private final int rank;
    private static Gourd[] gourds;

    static {
        gourds = null;
    }

    private Position position;

    Gourd(int r, int g, int b,int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank=rank;
    }

    private static int[] randomList(int num) {
        int len = 256;
        int[] source = new int[len];
        for (int i = 0; i < len; i++) {
            source[i] = i;
        }
        int[] result = new int[num];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < num; i++) {
            index = Math.abs(rd.nextInt() % len--);
            result[i] = source[index];
            source[index] = source[len];
        }
        return result;
    }

    public static void generateGourds(int num) {
        Gourd.gourds = new Gourd[num];
        int[] rs = Gourd.randomList(num);
        int[] gs = Gourd.randomList(num);
        int[] bs = Gourd.randomList(num);
        for (int i = 0; i < num; i++) {
            Gourd.gourds[i] = new Gourd(rs[i], gs[i], bs[i],i);
        }
    }

    public static Gourd[] getGourds() {
        return gourds;
    }

    public static Gourd getGourdByRank(int rank) {
        return Gourd.gourds[rank-1];
    }

    public int rank() {
        return this.rank+ 1;
    }

    @Override
    public String toString() {
        if(this.rank()<10) return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m     " + this.rank() + "  \033[0m";
        else return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Gourd another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}