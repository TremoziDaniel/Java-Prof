package homeWork22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HomeWork22 {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];
    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        IntStream.range(0, SIZE).forEach(i -> arr[i] = 1);

        // 1 Thread
        long time = System.currentTimeMillis();
        funcThread(arr, SIZE);
        System.out.println(System.currentTimeMillis() - time);

        float[] arrThread1 = giveHalfArray(arr, 0, HALF);
        float[] arrThread2 = giveHalfArray(arr, HALF, SIZE);

        // 2 Threads
        time = System.currentTimeMillis();
        withSplitThreads(arrThread1, arrThread2);
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void funcThread (float[] arr, int SIZE) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static float[] giveHalfArray (float[] arr, int FROM, int TO) {
        float[] newArr = new float[TO - FROM];

        for (int i = FROM; i < TO; i++) {
            newArr[i-FROM] = arr[i];
        }

        return newArr;
    }

    private static void withSplitThreads (float[] arr1, float[] arr2) {
        Thread thread1 = new Thread(() -> funcThread(arr1, arr1.length));
        Thread thread2 = new Thread(() -> funcThread(arr2, arr2.length));

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
