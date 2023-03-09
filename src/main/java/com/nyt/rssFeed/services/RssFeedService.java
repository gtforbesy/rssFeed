package com.nyt.rssFeed.services;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RssFeedService {

    static final String RSS_URL_STRING = "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";

    public List<Item> getRssFeed() {
        try {
            return new RssReader()
                    .addItemExtension("media:content", "url", Item::setComments)
                    .addItemExtension("dc:creator", Item::setAuthor)
                    .read(RSS_URL_STRING).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
