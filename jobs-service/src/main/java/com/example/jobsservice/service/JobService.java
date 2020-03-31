package com.example.jobsservice.service;

import com.example.mailservice.model.Job;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JobService {
    public List<Job> fetchJobs(){
        Document doc = null;
        List<Job> data = new ArrayList<>();

        try {
            doc = Jsoup.connect("https://www.linkedin.com/jobs/search/?geoId=103644278&keywords=java&location=United%20States").get();

            Elements div = doc.getElementsByClass("results__container");
            log.info(String.valueOf(div));
            div.forEach(entry ->{
                Elements ui = entry.getElementsByTag("ul");

                ui.forEach(job -> {
                    Elements li = job.getElementsByTag("li");
                    li.forEach(j -> {
                        String title = (j.getElementsByTag("h3").text());
                        String link = (j.getElementsByTag("a").attr("href"));
                        String company = (j.getElementsByClass("result-card__subtitle-link").text());
                        String location = (j.getElementsByClass("job-result-card__location").text());

                        Job jobEntry = new Job(title, company,location,link);
                        data.add(jobEntry);
                    });
                });
            });

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    return data;
    }
}
