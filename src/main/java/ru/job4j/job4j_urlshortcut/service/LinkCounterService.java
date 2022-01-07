package ru.job4j.job4j_urlshortcut.service;

import ru.job4j.job4j_urlshortcut.entity.LinkCounterResp;
import ru.job4j.job4j_urlshortcut.entity.Links;

import java.util.List;

public interface LinkCounterService {

    void createCounter(Links links);

    void incrementCounter(Links links);

    List<LinkCounterResp> findAll();
}
