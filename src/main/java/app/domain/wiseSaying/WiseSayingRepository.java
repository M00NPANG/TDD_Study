package app.domain.wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int lastId;

    public WiseSaying save(String content, String author) {
        lastId++;

        WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean deleteById(int id) {
        return wiseSayingList.removeIf(w -> w.getId() == id);
    }

    public WiseSaying findById(int id) {
        return wiseSayingList.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void edit(WiseSaying wiseSaying, String newContent, String newAuthor) {
            wiseSaying.setContent(newContent);
            wiseSaying.setAuthor(newAuthor);
    }
}
