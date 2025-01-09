package app.domain.wiseSaying;

import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository;
    List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.save(content, author);
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying getItems(int id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }

    public void edit(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSayingRepository.edit(wiseSaying,newContent, newAuthor);
    }
}
