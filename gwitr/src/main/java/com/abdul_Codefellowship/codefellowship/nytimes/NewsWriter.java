package com.abdul_Codefellowship.codefellowship.nytimes;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NewsWriter {

    Gson gson = new Gson();

    String fileName ="https://api.nytimes.com/svc/topstories/v2/world.json?api-key=5neIb4pi6anqka8tfFQFfK8VgfVAujRX";

    public News newsReport()
            throws IOException
    {
        try{

        HttpURLConnection test = createRequest(fileName);
        StringBuffer responseStringBuff = readResponse(test);
        News newReport = parseNews(responseStringBuff);
        return newReport;
        }
        catch (IOException e)
        {
            System.exit(-1);
        }
        return null;

    }




    public HttpURLConnection createRequest(String fileName) throws IOException
    {
        //dis the URL
        URL quoteUrl = new URL(fileName);
        //we want type HttpURL connection so we must cast
        HttpURLConnection quoteUrlConnection = (HttpURLConnection) quoteUrl.openConnection();
        quoteUrlConnection.setRequestMethod(("GET"));

        return quoteUrlConnection;
    }


    public StringBuffer readResponse(HttpURLConnection _connection) throws IOException
    {
        try(BufferedReader responseReader = new BufferedReader((
                new InputStreamReader(_connection.getInputStream())
        ))) {
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = responseReader.readLine()) != null) {
                content.append(inputLine);
            }
            return content;
        }
    }


    public News parseNews(StringBuffer _content) throws IOException
    {
        News newNews = gson.fromJson(String.valueOf(_content), News.class);
        return newNews;
    }
}
