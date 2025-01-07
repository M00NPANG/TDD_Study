import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AppTest {
    @Test
    @DisplayName("시작 시 출력 : == 명언 앱 == ")
    void t1() {
        // given
        String out = TestBoot.run("종료");

        // then
        assertThat(out).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("시작 시 출력2 : 명령) ")
    void t2() {
        // given
        String out = TestBoot.run("종료");

        // then
        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ");
    }

    @Test
    @DisplayName("종료 입력 :  시스템을 종료합니다. 출력. 다만 == 명언 앱 ==과 명령) 다음에 출력되어야 한다.")
    void t3() {
        // given
        String out = TestBoot.run("종료");

        // then
        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ")
                .contains("시스템을 종료합니다.");
    }

    @Test
    @DisplayName("")
    void t4() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);

        // then
        assertThat(out)
                .containsSubsequence("명언 : ", "작가 : ");
      }



}
