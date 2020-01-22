public class Increment implements Operator {
    @Override
    public int operate(int output) {
        return ++output;
    }
}
