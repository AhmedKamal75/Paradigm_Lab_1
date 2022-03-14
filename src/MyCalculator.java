import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyCalculator extends Calculator<Double, Integer> {

    // unneeded code

    class DoubleToIntegerConverter implements Converter<Double, Integer> {
        @Override
        public Integer convertTo(Double v) {
            return v.intValue();
        }
    }

    class IntegerAdder implements Processor<Integer> {
        @Override
        public Integer process(Integer v1, Integer v2) {
            return v1 + v2;
        }
    }

    class IntegerSubtractor implements Processor<Integer> {
        @Override
        public Integer process(Integer v1, Integer v2) {
            return v1 - v2;
        }
    }

    class IntegerMultiplier implements Processor<Integer> {
        @Override
        public Integer process(Integer v1, Integer v2) {
            return v1 * v2;
        }
    }

    private DoubleToIntegerConverter myConverter = new DoubleToIntegerConverter();


    //

    // needed code

    private final Function<Double, Integer> converter = Double::intValue;
    private final Consumer<Integer> printer;

    public MyCalculator(Consumer<Integer> printer) {
        this.printer = printer;
    }

    public void add(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, converter, Integer::sum, printer);
    }

    public void subtract(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, converter, (integer, integer2) -> integer - integer2, printer);
    }

    public void multiply(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, converter, (integer, integer2) -> integer * integer2, printer);
    }

    //
}


