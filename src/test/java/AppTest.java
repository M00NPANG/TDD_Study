import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @DisplayName("시작 시 출력 : == 명언 앱 == ")
    @Test
    void t1() {
        // given
        TestBoot testBoot = new TestBoot();
        String out = testBoot.run("종료\n");
        assertThat(out).contains("== 명언 앱 ==");
    }

    @DisplayName("시작 시 출력2 : 명령) ")
    @Test
    void t2() {
        TestBoot testBoot = new TestBoot();
        String out = testBoot.run("종료\n");
        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ");
    }

    @DisplayName("종료 입력 :  시스템을 종료합니다. 출력. 다만 == 명언 앱 ==과 명령) 다음에 출력되어야 한다.")
    @Test
    void t3() {
        // given
        TestBoot testBoot = new TestBoot();
        String out = testBoot.run("종료\n");

        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ")
                .contains("시스템을 종료합니다.");
    }
}
