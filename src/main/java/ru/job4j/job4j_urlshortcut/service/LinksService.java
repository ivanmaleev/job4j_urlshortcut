package ru.job4j.job4j_urlshortcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_urlshortcut.common.Common;
import ru.job4j.job4j_urlshortcut.entity.Links;
import ru.job4j.job4j_urlshortcut.repository.LinkCounterRepository;
import ru.job4j.job4j_urlshortcut.repository.LinksRepository;

import javax.transaction.Transactional;

@Service
public class LinksService {

    private LinksRepository linksRepository;
    private LinkCounterService linkCounterService;

    @Autowired
    public LinksService(LinksRepository linksRepository, LinkCounterService linkCounterService) {
        this.linksRepository = linksRepository;
        this.linkCounterService = linkCounterService;
    }

    @Transactional
    public Links saveAndConvertToShortUrl(String longUrl) {
        Links byLongUrl = linksRepository.findByLongUrl(longUrl);
        if (byLongUrl != null) {
            throw new IllegalArgumentException("Link already added");
        }
        Links link = new Links();
        link.setLongUrl(longUrl);
        String newShortUrl = null;
        while (true) {
            newShortUrl = Common.generateString(6);
            Links byShortUrl = linksRepository.findByShortUrl(newShortUrl);
            if (byShortUrl == null) {
                break;
            }
        }
        link.setShortUrl(newShortUrl);
        link = linksRepository.save(link);
        linkCounterService.createCounter(link);
        return link;
    }

    public Links findByShortUrl(String shortUrl) {
        Links link = linksRepository.findByShortUrl(shortUrl);
        if (link == null) {
            throw new IllegalArgumentException("Link not found");
        }
        linkCounterService.incrementCounter(link);
        return link;
    }
}
