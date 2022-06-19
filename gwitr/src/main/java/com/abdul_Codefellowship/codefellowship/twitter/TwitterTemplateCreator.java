package com.abdul_Codefellowship.codefellowship.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateCreator {
    @Autowired
    private Environment env;
    @Value("${consumerKey}")
    private String userConsumerKey;
    @Value("${consumerSecret}")
    private String userConsumerSecret;
    @Value("${accessToken}")
    private String userAccessToken;

    @Value("${accessTokenSecret}")
    private String userAccessTokenSecret;

    public Twitter getTwitterTemplate(/*String accountName*/) throws NullPointerException
    {
        String accountName = "gwitter-project";


        String consumerKey = env.getProperty(accountName + "." + userConsumerKey);
        String consumerSecret = env.getProperty(accountName + "." + userConsumerSecret);
        String accessToken = env.getProperty(accountName + "." + userAccessToken);
        String accessTokenSecret = env.getProperty(accountName +"." + userAccessTokenSecret);

            TwitterTemplate twitterTemplate =
                    new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
            return twitterTemplate;

    }

}
