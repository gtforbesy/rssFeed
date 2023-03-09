package com.nyt.rssFeed.controllers;

import com.apptasticsoftware.rssreader.Item;
import com.nyt.rssFeed.services.RssFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rssFeed")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class RssFeedController {

    private final RssFeedService rssFeedService;

    @GetMapping
    public List<Item> getRssFeed() {
        return rssFeedService.getRssFeed();
    }
}
