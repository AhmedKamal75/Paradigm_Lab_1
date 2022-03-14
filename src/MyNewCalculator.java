import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyNewCalculator extends Calculator<Double, Integer>{

    private final Function<Double, Integer> myConverter = Double::intValue;
    private final Consumer<Integer> printer;
    public MyNewCalculator(Consumer<Integer> printer) {
        this.printer = printer;
    }
    public void add(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, myConverter, Integer::sum, printer);
    }
    public void subtract(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, myConverter, (x, y) -> x - y, printer);
    }
    public void multiply(Supplier<Double> input1, Supplier<Double> input2) {
        process(input1, input2, myConverter, (x, y) -> x * y, printer);
    }
}


