package effectivejava.chapter2.item6;

import java.util.Comparator;

// Hideously slow program! Can you spot the object creation? (Page 24)
//这段程序结果是对的，但是运行性能比实际情况慢很多，因为打错了一个字符(变量被声明为Long而不是long)
//意味着程序构造了大约2^31个多余的Long实例(大约每次往Long sum中增加long时构造一个实例)
//所以要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
public class Sum {
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}