package ru.job4j.job4j_urlshortcut.service;

import ru.job4j.job4j_urlshortcut.entity.Links;

public interface LinksService {

    Links saveAndConvertToShortUrl(String longUrl);

    Links findByShortUrl(String shortUrl);
}
