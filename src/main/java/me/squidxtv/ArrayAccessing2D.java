package me.squidxtv;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
public class ArrayAccessing2D {

    @Benchmark
    public void rowFirst(Blackhole bh) {
        int[][] array = new int[10000][10000];

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                array[row][column]++;
            }
        }

        bh.consume(array);
    }

    @Benchmark
    public void columnFirst(Blackhole bh) {
        int[][] array = new int[10000][10000];

        for (int column = 0; column < array[0].length; column++) {
            for (int row = 0; row < array.length; row++) {
                array[row][column]++;
            }
        }

        bh.consume(array);
    }


    @Benchmark
    public void rowFirst1D(Blackhole bh) {
        int width = 10000, height = 10000;

        int[] array = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                array[y * height + x]++;
            }
        }

        bh.consume(array);
    }

    @Benchmark
    public void columnFirst1D(Blackhole bh) {
        int width = 10000, height = 10000;

        int[] array = new int[width * height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                array[y * height + x]++;
            }
        }

        bh.consume(array);
    }


}

