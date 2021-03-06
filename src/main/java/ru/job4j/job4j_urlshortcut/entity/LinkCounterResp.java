package ru.job4j.job4j_urlshortcut.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LinkCounterResp {
    private String url;
    private int total;

    public LinkCounterResp(LinkCounter linkCounter) {
        this.url = linkCounter.getLinks().getLongUrl();
        this.total = linkCounter.getCounter();
    }
}
