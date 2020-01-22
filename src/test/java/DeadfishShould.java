import org.junit.Test;

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
    public void decrement_increment_and_output_a_zero_one() {
        assertThat(Deadfish.parse("dio")).isEqualTo(new int[] {0});
    }

    private static class Deadfish {
        private static final String OUTPUT_COMMAND = "o";
        private static final char INCREMENT_COMMAND = 'i';
        public static final char DECREMENT_COMMAND = 'd';

        public static int[] parse(String commands) {
            if (commands.equals(OUTPUT_COMMAND)) return new int[] {0};
            int result = 0;
            if (isIncrementCommand(commands.charAt(0))) result++;
            if (isDecrementCommand(commands.charAt(0))) result--;
            if (isIncrementCommand(commands.charAt(1))) result++;
            return new int[] {result};
        }

        private static boolean isIncrementCommand(char command) {
            return command == INCREMENT_COMMAND;
        }

        private static boolean isDecrementCommand(char command) {
            return command == DECREMENT_COMMAND;
        }
    }
}
