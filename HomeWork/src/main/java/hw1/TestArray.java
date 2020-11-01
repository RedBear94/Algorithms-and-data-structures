package hw1;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Random;

public class TestArray {

    public static void main(String[] args) {
        testDynamicArray();
    }

    private static void testDynamicArray() {
        Array<Integer> data = new ArrayImpl<>(75000);
        Array<Integer> data2 = new ArrayImpl<>(75000);
        Array<Integer> data3 = new ArrayImpl<>(75000);

        for(int i = 0; i < 75000; i++){
            int rand = getRandomNumber();
            data.add(rand);
            data2.add(rand);
            data3.add(rand);
        }

//        System.out.println("data");
//        data.display();
//        System.out.println("data2");
//        data2.display();
//        System.out.println("data3");
//        data3.display();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        data.sortBubble();
        stopWatch.stop();
        System.out.println("data | Прошло времени, мс: " + stopWatch.getTime()); //
//        data.display();
        stopWatch.reset();

        stopWatch.start();
        data2.sortSelect();
        stopWatch.stop();
        System.out.println("data2 | Прошло времени, мс: " + stopWatch.getTime()); //
//        data2.display();
        stopWatch.reset();

        stopWatch.start();
        data3.sortInsert();
        stopWatch.stop();
        System.out.println("data3 | Прошло времени, мс: " + stopWatch.getTime()); //
//        data3.display();
        stopWatch.reset();
    }

    public static int getRandomNumber()
    {
        Random rnd = new Random();
        return rnd.nextInt(1000);
    }
}
