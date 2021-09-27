package code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {
        int num=16;

        Gourd.generateGourds(num);

        Line line = new Line(num);
        line.randomPut(Gourd.getGourds());
        // line.put(Gourd.ONE, 6);
        // line.put(Gourd.TWO, 3);
        // line.put(Gourd.THREE, 1);
        // line.put(Gourd.FOUR, 5);
        // line.put(Gourd.FIVE, 2);
        // line.put(Gourd.SIX, 4);
        // line.put(Gourd.SEVEN, 0);

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter1 = new BubbleSorter();
        Sorter sorter2 = new SelectionSorter();

        theSnake.setSorter(sorter2);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
