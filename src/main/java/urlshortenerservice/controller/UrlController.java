package urlshortenerservice.controller;

import urlshortenerservice.dto.LongUrlDto;
import urlshortenerservice.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping
@Tag(name = "URL SHORTENER.", description = "You can make your URL shorter =)")
public class UrlController {
    public final UrlService urlService;

    @PostMapping
    @Operation(summary = "Create short URL", description = "Put your URL into request body, and you'll get short version")
    public ResponseEntity<String> createShortUrl(@Valid @RequestBody LongUrlDto longUrlDto) {
        log.info("Requesting short URL for '{}'", longUrlDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.createShortUrl(longUrlDto));
    }

    @GetMapping("/{hash}")
    @Operation(summary = "Get original URL by hash", description = "Put short url and you'll be redirected.")
    public ResponseEntity<Void> getLongUrl(@PathVariable
                                           @NotBlank(message = "Hash must not be empty")
                                           @Size(min = 6, max = 6, message = "Hash must contain 6 chars.")
                                           @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "0-9, a-z, A-Z chars only")
                                           String hash) {
        log.info("Requesting long URL for hash '{}'", hash);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, urlService.getLongUrl(hash))
                .build();
    }
}
