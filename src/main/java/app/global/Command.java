package app.global;

public class Command {

    String actionName;
    String pramKey;
    String pramValue;

    public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            return;
        }

        String param = cmdBits[1];
        String[] paramBits = param.split("=", 2);
        if(paramBits.length < 2) {
            return;
        }
        pramKey = paramBits[0];
        pramValue = paramBits[1];
    }

    // 명령어?=id=1  -> 명령어 |?| id=1 분리해서 반환하는 기능
    public String getActionName() {
        return  actionName;
    }

    public String getPram() {
        return pramValue;
    }

    // id=1 -> id |=| 1 분리하고 정수로 변환해서 반화하는 기능
}
