import java.util.Scanner;

public class App {
    private final Scanner sc;

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
                    String Content = sc.nextLine();
                    System.out.println("작가 : ");
                    String Author = sc.nextLine();
                    System.out.println("1번 명언이 등록되었습니다.");
                    System.out.println("2번 명언이 등록되었습니다.");
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
