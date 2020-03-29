package com.example.coronadata.service;
import com.example.coronadata.model.CoronaData;
import com.example.coronadata.proxy.CoronaCountryProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CoronaService {
    private final CoronaCountryProxy coronaCountryProxy;
    List<CoronaData> coronaData;


    public List<CoronaData> getData() {
        List<String> countries = coronaCountryProxy.getCountries();
        List<CoronaData> data = new ArrayList<>();
        countries.forEach(country -> {
            for (CoronaData d : coronaData.stream().collect(Collectors.toList())){
                if(d.getCountry().equals(country)){
                    data.add(d);
                }
            }
        });
        return data;
    }

    public List<CoronaData> scrapeData() {
        Document doc = null;
        List<List<String>> data = new ArrayList<>();

        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
            Element table = doc.getElementById("main_table_countries_today");
            Elements tbody = table.getElementsByTag("tbody");
            tbody.forEach(body -> {
                Elements countries = body.getElementsByTag("tr");
                countries.forEach(country -> {
                    List<String> row_data = (country.getElementsByTag("td").stream().map(tdEl -> tdEl.text())
                            .collect(Collectors.toList()));
                   CoronaData corona = new CoronaData(row_data.get(0), row_data.get(1), row_data.get(2), row_data.get(3),  row_data.get(4),  row_data.get(5),  row_data.get(6),  row_data.get(7));
                   coronaData.add(corona);
                data.add(row_data);
                });
            });

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return coronaData;
    }

}