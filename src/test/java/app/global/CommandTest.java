package app.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    @DisplayName("Command 객체 생성 확인")
    void t1() {
        Command cmd = new Command();
      }

      @Test
      @DisplayName("명령?id=1 을/를 입력하면 ?를 기준으로 명령을 분리해 반환")
      void t2() {
          // given
          Command cmd = new Command();
          String actionName = cmd.getActionName("명령?id=1");

          // then
          assertThat(actionName).isEqualTo("명령");
        }
}
