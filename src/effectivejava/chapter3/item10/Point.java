package effectivejava.chapter3.item10;

// Simple immutable two-dimensional integer point class (Page 37)
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //比较了位置
    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

//    // Broken - violates Liskov substitution principle (page 43)
//    @Override public boolean equals(Object o) {
            //使用getClass代替instanceof，getClass只有是同个类才为正确，instanceof则可以用在父子类上
        //只有当对象具有相同的实现类时，才会产生相同的效果。这看起来可能不是那么糟糕，但是结果是不可接受的:
        //一个 Point 类子类的实例仍然是一个 Point 的实例，它仍然需要作为一个 Point 来运行，但是如果你采用这个方法，就会失败！
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    // See Item 11
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}
