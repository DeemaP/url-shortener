package urlshortenerservice.repository.hash;

import urlshortenerservice.model.Hash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomHashRepository {
    void saveAllWithJdbcTemplate(List<Hash> hashes);
}

