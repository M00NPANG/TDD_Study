import wiseSaying.domain.WiseSaying;

import java.util.*;

public class App {
    private final Scanner sc;
    List<WiseSaying> wiseSayingList = new ArrayList<>();;
    int LastId = 0;

    public App(Scanner sc) {
        this.sc = sc; // 외부에서 전달된 Scanner 사용
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" :
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    LastId++;

                    WiseSaying wiseSaying = new WiseSaying(LastId,content, author);
                    wiseSayingList.add(wiseSaying);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for(int i = wiseSayingList.size()-1 ; i >= 0; i--) {
                        WiseSaying w = wiseSayingList.get(i);
                        System.out.println("%d / %s / %s".formatted(w.getId(), w.getAuthor(), w.getContent()));
                    }

                    break;
                case "종료" :
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("알 수 없는 명령입니다.");
                    break;
            }
        }

    }
}
