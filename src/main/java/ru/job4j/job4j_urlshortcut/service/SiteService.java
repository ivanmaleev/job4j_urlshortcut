package ru.job4j.job4j_urlshortcut.service;

import ru.job4j.job4j_urlshortcut.entity.SiteRegResp;
import ru.job4j.job4j_urlshortcut.entity.Site;

public interface SiteService {

    SiteRegResp register(String siteName);

    Site findByUsername(String login);
}
