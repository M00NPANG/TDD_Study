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
            int pram = Integer.parseInt(cmd.getPram("id"));

            // then
            assertThat(pram).isEqualTo(1);
          }

    @Test
    @DisplayName("불완전한 파라미터 값 입력 1 : 명령?id=1=1")
    void t4() {
        // given
        Command cmd = new Command("명령?id=1=1");
        String pram = cmd.getPram("id");

        // then
        assertThat(pram).isEqualTo("1=1");
    }

    @Test
    @DisplayName("불완전한 파라미터 값 입력 2 : ")
    void t5() {
        // given
        Command cmd = new Command("목록?page");
        String pram = cmd.getPram("page");

        // then
        assertThat(pram).isNull();
    }

    @Test
    @DisplayName("파라미터 여러 개 입력 받기 : 명령?key1=value&key2=value2")
    void t6() {
        // given
        Command cmd = new Command("명령?key1=value1&key2=value2");
        String pram1 = cmd.getPram("key1");
        String pram2 = cmd.getPram("key2");

        // then
        assertThat(pram1).isEqualTo("value1");
        assertThat(pram2).isEqualTo("value2");
    }


}
