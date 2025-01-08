import java.io.*;
import java.util.*;

public class TestBoot {
    public static String run(String input) {
        // given
        Scanner sc = new Scanner(input+ "종료\n");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // 표준 출력 캡처

        // when
        App app = new App(sc);
        app.run();

        // then
        System.setOut(originalOut); // 표준 출력 복원
        String output = out.toString();
        System.out.println(output); // 캡처된 내용을 콘솔에 출력

        return output;
    }
}
