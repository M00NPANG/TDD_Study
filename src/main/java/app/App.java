package app;

import app.domain.wiseSaying.WiseSayingController;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    WiseSayingController wiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController. actionList();
                case "삭제" -> wiseSayingController.actionDelete(cmd);
               //  case "수정" -> wiseSayingController.actionEdit(cmd);
                case "종료" -> {
                    wiseSayingController.actionExit();
                    return; // 메서드 종료
                }

                default -> System.out.println("알 수 없는 명령입니다.");
            }
        }

    }
}
