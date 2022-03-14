import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Calculator<I, O> {
    protected void process(Supplier<I> firstInput, Supplier<I> secondInput,
                           Function<I, O> converter,
                           BinaryOperator<O> p,
                           Consumer<O> output) {
        I x = firstInput.get();
        I y = secondInput.get();
        O valueX = converter.apply(x);
        O valueY = converter.apply(y);
        O result = p.apply(valueX, valueY);
        output.accept(result);
    }
}

