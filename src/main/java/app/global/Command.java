package app.global;

import java.util.HashMap;
import java.util.Map;

public class Command {

    String actionName;

    Map<String, String> paramMap = new HashMap<>();

    public Command(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            return;
        }

        String qureyString = cmdBits[1];
        String[] params =qureyString .split("&");

        for(String param : params) {
            String[] paramBits = param.split("=", 2);

            if(paramBits.length < 2) {
                return;
            }

            paramMap.put(paramBits[0], paramBits[1]);
        }

    }

    // 명령어?=id=1  -> 명령어 |?| id=1 분리해서 반환하는 기능
    public String getActionName() {
        return  actionName;
    }

    public String getPram(String key) {
        return paramMap.get(key);
    }

    // id=1 -> id |=| 1 분리하고 정수로 변환해서 반화하는 기능
}
