package ru.job4j.job4j_urlshortcut.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_urlshortcut.entity.Links;

@Repository
public interface LinksRepository extends CrudRepository<Links, String> {

    Links findByShortUrl(String shortUrl);

    Links findByLongUrl(String longUrl);
}
