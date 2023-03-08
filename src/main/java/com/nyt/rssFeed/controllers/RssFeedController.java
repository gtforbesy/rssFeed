package com.nyt.rssFeed.controllers;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rssFeed")
@CrossOrigin(origins = "http://localhost:3000")
public class RssFeedController {

    private static final String RSS_URL_STRING = "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";

    @GetMapping
    public List<Item> getRssFeed() {
        //call url
        //https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml
        System.out.println("CALLED");
        RssReader rssReader = new RssReader();

        try {
            List<Item> items = rssReader.read(RSS_URL_STRING).toList();
//            URL url = new URL("http://example.com");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
            return items;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
