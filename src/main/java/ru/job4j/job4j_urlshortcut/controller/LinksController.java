package ru.job4j.job4j_urlshortcut.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_urlshortcut.entity.ConvertResp;
import ru.job4j.job4j_urlshortcut.entity.Links;
import ru.job4j.job4j_urlshortcut.entity.UrlReq;
import ru.job4j.job4j_urlshortcut.service.LinksService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/url")
@AllArgsConstructor
public class LinksController {

    private LinksService linksService;

    @PostMapping("/convert")
    public ResponseEntity<ConvertResp> convertToShortUrl(@RequestBody @Valid UrlReq Url) {
        Links link = linksService.saveAndConvertToShortUrl(Url.getUrl());
        ConvertResp convertResp = new ConvertResp(link.getShortUrl());
        return new ResponseEntity<>(convertResp,
                HttpStatus.CREATED);
    }

    @GetMapping("/redirect/{shortUrl}")
    public void redirectByShortUrl(HttpServletResponse resp, @PathVariable String shortUrl) throws IOException {
        Links link = linksService.findByShortUrl(shortUrl);
        resp.sendRedirect("http://" + link.getLongUrl());
    }
}
