import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AppTest {
    @Test
    @DisplayName("1단계. 시작 시 출력 : == 명언 앱 == ")
    void t1() {
        // given
        String out = TestBoot.run("");

        // then
        assertThat(out).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("1단계. 시작 시 출력2 : 명령) ")
    void t2() {
        // given
        String out = TestBoot.run("");

        // then
        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ");
    }

    @Test
    @DisplayName("1단계. 종료 입력 :  시스템을 종료합니다. 출력. 다만 == 명언 앱 ==과 명령) 다음에 출력되어야 한다.")
    void t3() {
        // given
        String out = TestBoot.run("");

        // then
        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "명령) ")
                .contains("시스템을 종료합니다.");
    }

    @Test
    @DisplayName("2단계. 명언 등록 : 명언 1개 등록")
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

    @Test
    @DisplayName("2단계. 명언 등록 : 명언 1개 등록")
    void t5() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        // then
        assertThat(out)
                .containsSubsequence("명령) ", "명언 : ", "작가 : ");
    }

    @Test
    @DisplayName("2단계 : 명언 2개 등록, 명언) 이 2번 출력되어야 한다.")
    void t6() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);

        // then
        long commandCount = out.lines()
                .filter(line -> line.startsWith("명령) "))
                .count();

        assertThat(commandCount).isEqualTo(3);

    }

    @Test
    @DisplayName("2단계 : 명언 2개 등록, 명언) 다음 명언 : 과 작가 : 가 2번씩 출력되어야 한다.")
    void t7() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);

        // then
        List<String> lines = out.lines().toList();

        int occurrences = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("명령) ")) {
                // "명령)", "명언 :", "작가 :" 순서 확인
                if (i + 2 < lines.size() &&
                        lines.get(i + 1).startsWith("명언 : ") &&
                        lines.get(i + 2).startsWith("작가 : ")) {
                    occurrences++;
                    i += 2; // 확인한 범위는 건너뛰기
                }
            }
        }

        assertThat(occurrences).isEqualTo(2); // 패턴이 2번 반복되었는지 확인
    }

    @Test
    @DisplayName("3단계. 명언 등록 시 1번 명언이 등록되었습니다. 출력")
    void t8() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        // then
        assertThat(out).contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("4단계. 명언 2개 등록 시 각각 1번 명언... 2번 명언 출력")
    void t9() {
        // given
        String out = TestBoot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);

        // then
        assertThat(out)
                .containsSubsequence("1번 명언이 등록되었습니다.", "2번 명언이 등록되었습니다.");
    }

}
