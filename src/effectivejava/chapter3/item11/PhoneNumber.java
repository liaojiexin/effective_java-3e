package effectivejava.chapter3.item11;
import java.util.*;

// Shows the need for overriding hashcode when you override equals (Pages 50-53 )
//为不相等的对象产生不相等的散列码，理想情况下散列函数应该把集合中不相等的实例均匀地分布到所有可能的int值上。
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


    // Broken with no hashCode; works with any of the three below
    //1、声明一个int变量并命名为result，将它初始化为对象中第一个关键的散列码c，如2.a中计算所示
    //2、对象中剩下的每一个关键域f都完成以下步骤：
    // a.为该域计算int类型的散列码c
    //      Ⅰ.如果该域是基本类型，则计算Type.hashCode(f)，这里的Type是装箱基本类型的类，与f的类型相对应。
    //      Ⅱ.如果该域是一个对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域，则同样为这个
    //          域递归地调用hashCode。如果需要更复杂的比较，则为这个域计算一个“范式”，然后针对这个范式调用hashCode。
    //          如果这个域的值为null，则返回0(或者其他某个常数，但通常是0)
    //      Ⅲ.如果该域是一个数组，则要把每一个元素当作单独的域来处理。也就是说，递归地应用上述规则，对每个重要的元素
    //          计算一个散列码，然后根据步骤2.b中的做法把这些散列值组合起来。如果数组域中没有重要的元素，可以使用一个
    //          常数，但最好不要用0。如果数组域中的所有元素都很重要可以使用Arrays.hashCode方法。
    // b.按照下面的公式，把步骤2.a中计算得到的散列码c合并到result中
    //3、返回result
//    // Typical hashCode method (Page 52)
//    @Override public int hashCode() {
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

//    // One-line hashCode method - mediocre performance  (page 53)
//    @Override public int hashCode() {
            //hash方法和上面一样，不过运行速度慢了点，因为它们会引发数组的创建，以便传入数目可变的参数，如果有基本类型还会有拆箱装箱操作
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

//    // hashCode method with lazily initialized cached hash code  (page 53)  延迟初始化
    //如果一个类是不可变的，并且计算散列码的开销也比较大，就应该考虑把散列码缓存在对象内部，而不是每次请求
    //的时候都重新计算散列码。
//    private int hashCode; // Automatically initialized to 0
//
//    @Override public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
