package com.nyt.rssFeed.controllers;

import com.nyt.rssFeed.services.RssFeedService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RssFeedControllerTest {

    private MockMvc mockMvc;
    @Mock
    private RssFeedService mockRssFeedService;

    @InjectMocks
    private RssFeedController rssFeedController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(rssFeedController)
                .build();
    }

    @Test
    void getRssFeed_returns200() throws Exception {
        mockMvc.perform(get("/rssFeed")).andExpect(status().isOk());
    }

    @Test
    void default_get_calls_rssFeedService_getRssFeed() throws Exception {
        mockMvc.perform(get("/rssFeed"));

        verify(mockRssFeedService).getRssFeed();
    }
}
