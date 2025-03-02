package faang.school.urlshortenerservice.repository.hash;

import faang.school.urlshortenerservice.model.Hash;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CustomHashRepositoryImpl implements CustomHashRepository {

    private final JdbcTemplate jdbcTemplate;

    @Value("${hash-properties.hash-saving-sql}")
    private String hashSavingSql;

    @Value("${hash-properties.saving-batch-size}")
    private int batchSize;

    @Override
    public void saveAllWithJdbcTemplate(List<Hash> hashes) {
        List<List<Hash>> partitions = IntStream.range(0, (hashes.size() + batchSize - 1) / batchSize)
                .mapToObj(i -> hashes.subList(i * batchSize, Math.min(hashes.size(), (i + 1) * batchSize)))
                .toList();

        partitions.forEach(batch -> {
            try {
                List<Object[]> batchArgs = batch.stream()
                        .map(hash -> new Object[]{hash.getHash()})
                        .toList();
                jdbcTemplate.batchUpdate(hashSavingSql, batchArgs);

                log.info("Successfully saved {} hashes.", batch.size());
            } catch (DataAccessException e) {
                log.error("Error while saving batch, skipping this batch: {}", e.getMessage());
            }
        });
    }
}
