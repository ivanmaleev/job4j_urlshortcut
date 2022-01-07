package ru.job4j.job4j_urlshortcut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_urlshortcut.common.Common;
import ru.job4j.job4j_urlshortcut.entity.SiteRegResp;
import ru.job4j.job4j_urlshortcut.entity.Role;
import ru.job4j.job4j_urlshortcut.entity.Site;
import ru.job4j.job4j_urlshortcut.repository.RoleRepository;
import ru.job4j.job4j_urlshortcut.repository.SiteRepository;
import ru.job4j.job4j_urlshortcut.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteRepository siteRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.siteRepository = siteRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public SiteRegResp register(String siteName) throws IllegalArgumentException {
        SiteRegResp response = new SiteRegResp();
        Site site = new Site();
        site.setUsername(siteName);
        Site siteInDB = siteRepository.findByUsername(site.getUsername());
        if (siteInDB == null) {
            String newPassword = Common.generateString(16);
            response.setPassword(newPassword);
            site.setPassword(encoder.encode(newPassword));
            Role role = roleRepository.findByName("ROLE_USER");
            site.addRole(role);
            site = siteRepository.save(site);
            response.setRegistration(true);
            response.setLogin(site.getUsername());
        } else {
            response.setRegistration(false);
        }
        return response;
    }

    @Override
    public Site findByUsername(String login) {
        return siteRepository.findByUsername(login);
    }
}
