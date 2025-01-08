package app.domain.wiseSaying;

import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository;
    List<WiseSaying> wiseSayingList;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = wiseSayingRepository.save(content, author);
        return wiseSaying;
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.deleteById(id);
    }
}
