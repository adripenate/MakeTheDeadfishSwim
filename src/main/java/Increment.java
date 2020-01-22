public class Increment implements Operator {
    @Override
    public int operate(int number) {
        return ++number;
    }
}
