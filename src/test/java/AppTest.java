import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @DisplayName("시작 시 출력 : == 명언 앱 == ")
    @Test
    void t1() {
        // given
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // 표준 출력 캡처

        // when
        App app = new App();
        app.run();

        // then
        System.setOut(originalOut);
        assertThat(out.toString())
                .contains("== 명언 앱 ==");
    }

    @DisplayName("시작 시 출력2 : 명령) ")
    @Test
    void t2() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // 표준 출력 캡처

        // when
        App app = new App();
        app.run();

        // then
        System.setOut(originalOut);
        assertThat(out.toString()).
                contains("== 명언 앱 ==")
                .contains("명령) ");
    }
}
