package ru.job4j.job4j_urlshortcut.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "counter")
@Data
@NoArgsConstructor
public class LinkCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Links links;
    private int counter = 0;

    public LinkCounter(Links links) {
        this.links = links;
    }
}
