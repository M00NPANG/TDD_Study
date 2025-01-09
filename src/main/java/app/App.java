package app;

import app.domain.wiseSaying.WiseSayingController;
import app.global.Command;

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
            Command command = new Command(sc.nextLine());
            String actionName = command.getActionName();
            int id = command.getParamToInt("id");

            switch (actionName) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController. actionList();
                case "삭제" -> wiseSayingController.actionDelete(id);
                case "수정" -> wiseSayingController.actionEdit(id);
                case "종료" -> {
                    wiseSayingController.actionExit();
                    return; // 메서드 종료
                }

                default -> System.out.println("알 수 없는 명령입니다.");
            }
        }

    }
}
