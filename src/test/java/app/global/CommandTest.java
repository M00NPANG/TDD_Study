package app.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    @DisplayName("Command 객체 생성 확인")
    void t1() {
        Command cmd = new Command("명령?id=1");
      }

      @Test
      @DisplayName("명령?id=1 을/를 입력하면 ?를 기준으로 명령을 분리해 반환")
      void t2() {
          // given
          Command cmd = new Command("명령?id=1");
          String actionName = cmd.getActionName();

          // then
          assertThat(actionName).isEqualTo("명령");
        }

        @Test
        @DisplayName("명령?id=1 을/를 입력하면 ?를 기준으로 뒤의 파라미터 값을 반환")
        void t3() {
            // given
            Command cmd = new Command("명령?id=1");
            int pram = Integer.parseInt(cmd.getPram());

            // then
            assertThat(pram).isEqualTo(1);
          }


    @Test
    @DisplayName("불완전한 파라미터 값 입력 1 : 명령?id=1=1")
    void t4() {
        // given
        Command cmd = new Command("명령?id=1=1");
        String pram = cmd.getPram();

        // then
        assertThat(pram).isEqualTo("1=1");
    }

    @Test
    @DisplayName("불완전한 파라미터 값 입력 2 : ")
    void t5() {
        // given
        Command cmd = new Command("목록?page");
        String pram = cmd.getPram();

        // then
        assertThat(pram).isNull();
    }

}
