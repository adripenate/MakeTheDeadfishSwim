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
    public void operate_and_output_a_zero() {
        assertThat(Deadfish.parse("ido")).isEqualTo(new int[] {0});
    }

    private static class Deadfish {
        private static final String OUTPUT_COMMAND = "o";

        public static int[] parse(String commands) {
            if (commands.equals(OUTPUT_COMMAND)) return new int[] {0};
            return new int[] {1};
        }
    }
}
