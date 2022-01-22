package ru.job4j.job4j_urlshortcut.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.job4j_urlshortcut.entity.Site;
import ru.job4j.job4j_urlshortcut.service.impl.SiteServiceImpl;

import static java.util.Collections.emptyList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private SiteServiceImpl siteService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Site site = siteService.findByUsername(login);
        if (site == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(site.getUsername(), site.getPassword(), emptyList());
    }
}