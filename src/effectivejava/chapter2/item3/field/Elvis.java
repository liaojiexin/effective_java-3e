package effectivejava.chapter2.item3.field;

// Singleton with public final field  (Page 17)
//可以借助AccessibleObject.setAccessible方法通过反射机制来调用私有构造器，如果要抵御这种攻击，
// 可以修改构造器，让它在被要求创建第二个实例的时候抛出异常
public class Elvis {
    //私有构造器仅被调用一次，用来实例化公有的静态final域Elvis.INSTANCE（关键：final、static）
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}