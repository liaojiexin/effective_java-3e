package effectivejava.chapter2.item2.javabeans;

// JavaBeans Pattern - allows inconsistency, mandates mutability  (pages 11-12)
//javabeans模式下先调用一个无参构造器来创建对象，然后再调用setter方法来设置每个必要的参数，以及每个相关的可选参数

//解决了重叠构造器的不足，但是JavaBean模式自身也有很严重的缺点，因为构造过程被分到几个调用中，在
//构造过程中JavaBean可能处于不一致的状态，类无法通过验证构造器参数的有效性来保证一致性。
//另外JavaBean模式使得把类做成不可变的可能性不复存在，这就需要程序员付出额外的努力来确保它的线程安全
public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize  = -1; // Required; no default value
    private int servings     = -1; // Required; no default value
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFacts() { }
    // Setters
    public void setServingSize(int val)  { servingSize = val; }
    public void setServings(int val)     { servings = val; }
    public void setCalories(int val)     { calories = val; }
    public void setFat(int val)          { fat = val; }
    public void setSodium(int val)       { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}