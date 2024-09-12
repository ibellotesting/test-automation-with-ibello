package ibello.tools;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class DateToolTest {
    
    @Test
    public void localDateToString() {
        String date = DateTool.localDateToString(LocalDate.of(2024, 9, 12));
        Assertions.assertThat(date).isEqualTo("2024-09-12");
    }
    
}
