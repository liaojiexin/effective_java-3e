package effectivejava.chapter3.item10.inheritance;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

// Attempting to add a value component to Point (Page 41)
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates symmetry!  (Page 41)
    //比较了位置和颜色
    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

//    // Broken - violates transitivity! (page 42)
    //混合比较的方式，和Point的第一个equals方法使用会照成传递性问题
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        // If o is a normal Point, do a color-blind comparison
            //Point父类对象直接调用父类equals方法
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        // o is a ColorPoint; do a full comparison
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    public static void main(String[] args) {
        // First equals function violates symmetry (Page 42)
        //如果使用ColorPoint和Point的第一个equals方法，违反了对称性，因为ColorPoint的equals对比了位置和颜色，但是Point只对比了位置
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // Second equals function violates transitivity (Page 42)
        //如果使用ColorPoint的第二个equals和Point的第一个equals，违反了传递性。因为下面第一和第二个equals比较没有对比颜色，但是第三个equals方法对比了颜色
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        //结果为true，true，false
        System.out.printf("%s %s %s%n",
                          p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}
