package ru.job4j.job4j_urlshortcut.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_urlshortcut.entity.LinkCounter;
import ru.job4j.job4j_urlshortcut.entity.Links;

@Repository
public interface LinkCounterRepository extends CrudRepository<LinkCounter, Integer> {
    LinkCounter findByLinks(Links link);

    @Modifying
    @Query("update LinkCounter lc set lc.counter = (lc.counter + 1) where lc.links = :link")
    void increment(Links link);
}
