package effectivejava.chapter2.item7;
import java.util.*;

// Can you spot the "memory leak"?  (Pages 26-27)
// 如果一个栈先增长再收缩，那么从栈中弹出来的对象将不会被当作垃圾回收，即使使用栈的程序不再引用这些对象
// 这是因为栈内部维护着对这些对象的过期引用，所谓的过期引用就是指永远不会再被解除的引用
// 如果一个对象引用被无意识的保留起来了，那么垃圾回收机制不仅不会处理这个对象。而且不会处理被这个对象所引用的所有其他对象
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    //清空对象引用应该是一种例外，而不是一种规范行为，消除过期引用最好的方法是让包含该引用的变量结束其生命周期。
    //如果你是在最紧凑的作用域范围内定义每一个变量，这种情形就会自然而然地发生。
    //一般来说只要类是自己管理内存，程序员就应该警惕内存泄露问题。
//    // Corrected version of pop method (Page 27)
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        //将已经弹出的对象的引用清空，清空过期引用另一个好处就是它们以后又被错误地解除引用，程序就会被立即抛出NullPointerException异常
//        elements[size] = null; // Eliminate obsolete reference
//        return result;
//    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}
