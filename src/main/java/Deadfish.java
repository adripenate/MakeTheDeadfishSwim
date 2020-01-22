import java.util.LinkedList;
import java.util.List;

public class Deadfish {
    private static final char OUTPUT_COMMAND = 'o';

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
        return OperatorFactory.getOperator(command).operate(number);
    }

    private static boolean isOutputCommand(char command) {
        return command == OUTPUT_COMMAND;
    }
}
