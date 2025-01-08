package domain.wiseSayin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    int LastId = 0;
    private final Scanner sc;
    WiseSayingService wiseSayingService;
    List<WiseSaying> wiseSayingList = new ArrayList<>();

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();

        LastId++;

        WiseSaying wiseSaying = new WiseSaying(LastId,content, author);
        wiseSayingList.add(wiseSaying);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for(int i = wiseSayingList.size()-1 ; i >= 0; i--) {
            WiseSaying w = wiseSayingList.get(i);
            System.out.println("%d / %s / %s".formatted(w.getId(), w.getAuthor(), w.getContent()));
        }
    }

    public void actionExit() {
        System.out.println("시스템을 종료합니다.");
    }


}
