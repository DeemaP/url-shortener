package faang.school.urlshortenerservice.dto;

import jakarta.validation.constraints.Pattern;

public record LongUrlDto(
        @Pattern(regexp = "^(https?|ftp)://([^\\s/$.?#].\\S*)$", message = "Invalid URL format") String longUrl) {
}
