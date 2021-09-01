package effectivejava.chapter3.item10.inheritance;
import effectivejava.chapter3.item10.Point;

import java.util.concurrent.atomic.*;

// Trivial subclass of Point - doesn't add a value component (Page 43)
//以一种不添加值组件的简单方式继承 Point 类，比如让它的构造方法跟踪记录创建了多少实例
public class CounterPoint extends Point {
    private static final AtomicInteger counter =
            new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }
    public static int numberCreated() { return counter.get(); }
}
