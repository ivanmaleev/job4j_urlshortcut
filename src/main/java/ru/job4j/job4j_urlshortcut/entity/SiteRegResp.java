package ru.job4j.job4j_urlshortcut.entity;

import lombok.Data;

@Data
public class SiteRegResp {
    private boolean registration;
    private String login;
    private String password;
}
