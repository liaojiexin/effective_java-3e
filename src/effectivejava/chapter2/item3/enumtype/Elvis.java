package effectivejava.chapter2.item3.enumtype;

// Enum singleton - the preferred approach (Page 18)
//这种方法在功能上与公有域方法相似，但是更加简洁，无偿地提供了序列化机制，绝对防止多次实例化，
//即使是在面对复杂的序列化或者反射攻击的时候
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
