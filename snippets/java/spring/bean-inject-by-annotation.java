/**
 * Example of inject values to field by annotation and BeanPostProcessor.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
    int min();

    int max();
}

@Component
public class DataCache {
    @RandomInt(min = 2, max = 10)
    private int group;
    private String name;
}

@Component
public class RandomIntGenerator {
    private Random random = new Random();
    private DataCache dataCache;

    public RandomIntGenerator(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public int generate(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}

public class RandomIntProcessor implements BeanPostProcessor {
    private final RandomIntGenerator randomIntGenerator;

    @Lazy
    public RandomIntProcessor(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            RandomInt injectRandomInt = field.getAnnotation(RandomInt.class);
            if (injectRandomInt != null) {
                int min = injectRandomInt.min();
                int max = injectRandomInt.max();
                int randomValue = randomIntGenerator.generate(min, max);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomValue);
            }
        }

        return bean;
    }
}
