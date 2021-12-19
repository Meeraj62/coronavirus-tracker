package com.meeraj.coronavirus.service;

import com.meeraj.coronavirus.model.Location;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VirusDataService {
    // private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-states.csv";
    // date,state,fips,cases,deaths

    List<Location> locationData = new ArrayList<>();

    public List<Location> getLocationData() {
        return locationData;
    }

    @PostConstruct
    public void fetchVirusData() throws IOException, InterruptedException {
        //
        List<Location> newLocationData = new ArrayList<>();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        StringReader stringReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        for (CSVRecord record : records) {

            Location location = new Location();
            location.setDate(record.get("date"));
            location.setState(record.get("state"));
            location.setCases(Integer.parseInt(record.get("cases")));
            location.setDeaths(Integer.parseInt(record.get("deaths")));

            newLocationData.add(location);
        }
        this.locationData = newLocationData;
    }
}
