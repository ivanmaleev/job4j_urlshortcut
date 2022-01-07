package ru.job4j.job4j_urlshortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_urlshortcut.entity.Site;

@Repository
public interface SiteRepository extends CrudRepository<Site, Integer> {

    Site findByUsername(String login);
}
