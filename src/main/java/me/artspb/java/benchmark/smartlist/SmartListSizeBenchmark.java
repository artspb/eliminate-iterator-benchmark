package me.artspb.java.benchmark.smartlist;

import com.intellij.util.SmartList;
import com.intellij.util.SmartListImproved;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@State(Scope.Benchmark)
public class SmartListSizeBenchmark {

    @Param({"0", "1", "2", "3", "10", "100", "1000", "10000", "100000"})
    public int size;

    private String[] strings;
    private List<String> smartList;
    private List<String> smartListImproved;
    private List<String> arrayList;
    private List<String> factoryList;

    @Setup(Level.Trial)
    public void init() {
        strings = Utils.randomStrings(size);
        smartList = Utils.fill(new SmartList<>(), size);
        smartListImproved = Utils.fill(new SmartListImproved<>(), size);
        arrayList = Utils.fill(new ArrayList<>(), size);
        factoryList = Utils.fillFactory(size);
    }

    @Benchmark
    public int baseline() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += strings[i].length();
        }
        return sum;
    }

    @Benchmark
    public int smartList_fori() {
        int sum = 0;
        final List<String> list = smartList;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i).length();
        }
        return sum;
    }

    @Benchmark
    public int smartListImproved_fori() {
        int sum = 0;
        final List<String> list = smartListImproved;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i).length();
        }
        return sum;
    }

    @Benchmark
    public int arrayList_fori() {
        int sum = 0;
        final List<String> list = arrayList;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i).length();
        }
        return sum;
    }

    @Benchmark
    public int factoryList_fori() {
        int sum = 0;
        final List<String> list = factoryList;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i).length();
        }
        return sum;
    }

    @Benchmark
    public int smartList_iter() {
        int sum = 0;
        final List<String> list = smartList;
        for (final String s : list) {
            sum += s.length();
        }
        return sum;
    }

    @Benchmark
    public int smartListImproved_iter() {
        int sum = 0;
        final List<String> list = smartListImproved;
        for (final String s : list) {
            sum += s.length();
        }
        return sum;
    }

    @Benchmark
    public int arrayList_iter() {
        int sum = 0;
        final List<String> list = arrayList;
        for (final String s : list) {
            sum += s.length();
        }
        return sum;
    }

    @Benchmark
    public int factoryList_iter() {
        int sum = 0;
        final List<String> list = factoryList;
        for (final String s : list) {
            sum += s.length();
        }
        return sum;
    }
}