package com.nyt.rssFeed.services;

import com.apptasticsoftware.rssreader.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class RssFeedServiceTest {

    @InjectMocks
    public RssFeedService rssFeedService;

    @Test
    void getRssFeed_returnsResult() {
        List<Item> result = rssFeedService.getRssFeed();

        assertFalse(result.isEmpty());
    }
}
