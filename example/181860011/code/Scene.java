package code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {
        // int num=16;

        // Gourd.generateGourds(num);

        // Line line = new Line(num);
        // line.randomPut(Gourd.getGourds());

        int num=64;
        int height=8;
        int width=8;
        Gourd.generateGourds(num);
        Matrix matrix=new Matrix(height, width);
        matrix.randomPut(Gourd.getGourds());


        Snake theSnake = Snake.getTheSnake();

        Sorter sorter1 = new BubbleSorter();
        Sorter sorter2 = new SelectionSorter();

        theSnake.setSorter(sorter2);

        //String log = theSnake.lineUp(line);
        String log = theSnake.matrixSort(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
