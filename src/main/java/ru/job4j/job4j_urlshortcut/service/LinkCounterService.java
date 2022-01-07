package ru.job4j.job4j_urlshortcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.job4j_urlshortcut.entity.LinkCounter;
import ru.job4j.job4j_urlshortcut.entity.LinkCounterResp;
import ru.job4j.job4j_urlshortcut.entity.Links;
import ru.job4j.job4j_urlshortcut.repository.LinkCounterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkCounterService {

    private LinkCounterRepository linkCounterRepository;

    @Autowired
    public LinkCounterService(LinkCounterRepository linkCounterRepository) {
        this.linkCounterRepository = linkCounterRepository;
    }

    @Transactional
    public void incrementCounter(Links links) {
        linkCounterRepository.increment(links);
    }

    public void createCounter(Links links) {
        LinkCounter linkCounter = new LinkCounter(links);
        linkCounterRepository.save(linkCounter);
    }

    public List<LinkCounterResp> findAll() {
        List<LinkCounterResp> counterList = new ArrayList<>();
        Iterable<LinkCounter> linkCounters = linkCounterRepository.findAll();
        for (LinkCounter counter : linkCounters) {
            counterList.add(new LinkCounterResp(counter));
        }
        return counterList;
    }
}
