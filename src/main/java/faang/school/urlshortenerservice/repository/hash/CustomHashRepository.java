package faang.school.urlshortenerservice.repository.hash;

import faang.school.urlshortenerservice.model.Hash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomHashRepository {
    void saveAllWithJdbcTemplate(List<Hash> hashes);
}

