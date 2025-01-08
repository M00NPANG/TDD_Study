package app.domain.wiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private final Scanner sc;
    WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.getAllItems();

        for(int i = wiseSayingList.size()-1 ; i >= 0; i--) {
            WiseSaying w = wiseSayingList.get(i);
            System.out.println("%d / %s / %s".formatted(w.getId(), w.getAuthor(), w.getContent()));
        }
    }

    public void actionExit() {
        System.out.println("시스템을 종료합니다.");
    }


    public void actionDelete(String cmd) {
        String param = cmd.split("\\?")[1];
        String[] paramBits = param.split("=");
        int id = Integer.parseInt(paramBits[1]);

        boolean isDelete = wiseSayingService.delete(id);

        if(isDelete) {
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        } else {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }

    }
}
