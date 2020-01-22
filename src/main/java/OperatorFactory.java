import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static Map<Character, Operator> operators = new HashMap<Character, Operator>(){{
        put('i', new Increment());
        put('d', new Decrement());
    }};


    public static Operator getOperator(char command) {
        return operators.get(command);
    }
}
