import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

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
                containsSubsequence("== 명언 앱 ==", "명령) ");
    }

    @DisplayName("종료 입력 :  시스템을 종료합니다. 출력. 다만 == 명언 앱 ==과 명령) 다음에 출력되어야 한다.")
    @Test
    void t() {
        // given
        Scanner sc = new Scanner("종료\n");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // 표준 출력 캡처

        // when
        App app = new App();
        app.run();

        // then
        System.setOut(originalOut);
        assertThat(out.toString())
                .containsSubsequence("== 명언 앱 ==", "명령) ")
                .contains("시스템을 종료합니다.");
    }
}
