import java.util.LinkedList;
import java.util.List;

public class Deadfish {
    private static final char OUTPUT_COMMAND = 'o';
    private static final char INCREMENT_COMMAND = 'i';
    private static final char DECREMENT_COMMAND = 'd';

    public static int[] parse(String commands) {
        List<Integer> outputs = new LinkedList<>();
        int output = 0;
        for (int i = 0; i<commands.length() ; i++){
            if (isOutputCommand(getCommand(commands, i))) outputs.add(output);
            else output = operateOnOutput(getCommand(commands, i), output);
        }
        return convertListToArray(outputs);
    }

    private static char getCommand(String commands, int i) {
        return commands.charAt(i);
    }

    private static int[] convertListToArray(List<Integer> outputs) {
        return outputs.stream().mapToInt(number -> number).toArray();
    }

    private static int operateOnOutput(char command, int number) {
        if (isIncrementCommand(command)) return OperatorFactory.getOperator(command).operate(number);
        else if (isDecrementCommand(command)) return --number;
        else return number*number;
    }

    private static boolean isIncrementCommand(char command) {
        return command == INCREMENT_COMMAND;
    }

    private static boolean isDecrementCommand(char command) {
        return command == DECREMENT_COMMAND;
    }

    private static boolean isOutputCommand(char command) {
        return command == OUTPUT_COMMAND;
    }
}
