package ru.job4j.job4j_urlshortcut.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.job4j_urlshortcut.entity.LinkCounter;
import ru.job4j.job4j_urlshortcut.entity.LinkCounterResp;
import ru.job4j.job4j_urlshortcut.entity.Links;
import ru.job4j.job4j_urlshortcut.repository.LinkCounterRepository;
import ru.job4j.job4j_urlshortcut.service.LinkCounterService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LinkCounterServiceImpl implements LinkCounterService {

    private LinkCounterRepository linkCounterRepository;

    @Override
    @Transactional
    public void incrementCounter(Links links) {
        linkCounterRepository.increment(links);
    }

    @Override
    public void createCounter(Links links) {
        LinkCounter linkCounter = new LinkCounter(links);
        linkCounterRepository.save(linkCounter);
    }

    @Override
    public List<LinkCounterResp> findAll() {
        List<LinkCounterResp> counterList = new ArrayList<>();
        Iterable<LinkCounter> linkCounters = linkCounterRepository.findAll();
        for (LinkCounter counter : linkCounters) {
            counterList.add(new LinkCounterResp(counter));
        }
        return counterList;
    }
}
