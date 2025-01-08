package domain.wiseSayin;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    //WiseSayingRepository wiseSayingRepository;
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId;

    public WiseSayingService() {
        //wiseSayingRepository = new wiseSayingRepository();
        lastId = 0;
    }

    public WiseSaying write(String content, String author) {
        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId,content, author);
        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingList;
    }
}
