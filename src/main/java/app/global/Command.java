package app.global;

public class Command {

    String actionName;
    // 명령어?=id=1  -> 명령어 |?| id=1 분리해서 반환하는 기능
    public String getActionName(String s) {
        String[] paramBits = s.split("\\?");
        actionName = paramBits[0];
        return  actionName;
    }

    // id=1 -> id |=| 1 분리하고 정수로 변환해서 반화하는 기능
}
