import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    Map<Character, Operator> operators = new HashMap<Character, Operator>(){{
        put('i', new Increment());
    }};
}
