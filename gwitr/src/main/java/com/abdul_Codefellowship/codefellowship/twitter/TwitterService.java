package com.abdul_Codefellowship.codefellowship.twitter;

import org.slf4j.LoggerFactory;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TwitterService {

    //private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    public void tweet(Twitter twitter, String tweetText) {
        try {
            twitter.timelineOperations().updateStatus(tweetText);
        } catch (RuntimeException ex) {
            System.out.println("Unable to tweet" + tweetText);
            System.exit(-1);
        }
    }
}
