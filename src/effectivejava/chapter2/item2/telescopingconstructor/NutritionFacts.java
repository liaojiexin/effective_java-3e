package effectivejava.chapter2.item2.telescopingconstructor;

// Telescoping constructor pattern - does not scale well! (Pages 10-11)
//第一个构造器只有必要的参数，第二个构造器包含第一个构造器和一个可选参数，第三个构造器...以此类推下去
public class NutritionFacts {
    private final int servingSize;  // (mL)            required必选
    private final int servings;     // (per container) required必选
    private final int calories;     // (per serving)   optional可选
    private final int fat;          // (g/serving)     optional可选
    private final int sodium;       // (mg/serving)    optional可选
    private final int carbohydrate; // (g/serving)     optional可选

    //第一个构造器
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    //第二个构造器
    public NutritionFacts(int servingSize, int servings,
                          int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    //最后一个构造器
    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    //缺点：这种方法通常需要需要你本不想要的参数，但还是不得不为它们传值，而且如果很容易不小心把参数顺序搞混
    public static void main(String[] args) {
        NutritionFacts cocaCola =
                new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
    
}