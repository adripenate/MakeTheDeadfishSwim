import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeadfishShould {
    @Test
    public void only_output_a_zero() {
        assertThat(Deadfish.parse("o")).isEqualTo(new int[] {0});
    }

    @Test
    public void increment_and_output_a_one() {
        assertThat(Deadfish.parse("io")).isEqualTo(new int[] {1});
    }

    @Test
    public void decrement_and_output_a_minus_one() {
        assertThat(Deadfish.parse("do")).isEqualTo(new int[] {-1});
    }

    @Test
    public void decrement_increment_and_output_a_zero() {
        assertThat(Deadfish.parse("dio")).isEqualTo(new int[] {0});
    }

    @Test
    public void increment_decrement_and_output_a_zero() {
        assertThat(Deadfish.parse("ido")).isEqualTo(new int[] {0});
    }

    @Test
    public void double_increment_squares_decrement_and_output_a_three() {
        assertThat(Deadfish.parse("iisdo")).isEqualTo(new int[] {3});
    }

    @Test
    public void output_two_numbers() {
        assertThat(Deadfish.parse("iisdoiiido")).isEqualTo(new int[] {3, 2});
    }

    private static class Deadfish {
        private static final char OUTPUT_COMMAND = 'o';
        private static final char INCREMENT_COMMAND = 'i';
        public static final char DECREMENT_COMMAND = 'd';

        public static int[] parse(String commands) {
            List<Integer> outputs = new LinkedList<>();
            int output = 0;
            for (int i = 0; i<commands.length() ; i++){
                if (commands.charAt(i) == OUTPUT_COMMAND) {
                    outputs.add(output);
                    output = 0;
                }
                else output = parseCommand(commands.charAt(i), output);
            }
            return convertListToArray(outputs);
        }

        private static int[] convertListToArray(List<Integer> outputs) {
            return outputs.stream().mapToInt(number -> number).toArray();
        }

        private static int parseCommand(char command, int number) {
            if (isIncrementCommand(command)) return ++number;
            else if (isDecrementCommand(command)) return --number;
            else return number*number;
        }

        private static boolean isIncrementCommand(char command) {
            return command == INCREMENT_COMMAND;
        }

        private static boolean isDecrementCommand(char command) {
            return command == DECREMENT_COMMAND;
        }
    }
}
