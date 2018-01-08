package com.company.tradeapp;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeApp {
    private String TradeFile;
    private String InstFile;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date StartDateTime;
    private Date EndDateTime;
    private List<CSVRecord> items = new ArrayList<>();


    TradeApp() {
        TradeFile = "resources/trades.txt";
        InstFile = "resources/inst.txt";
    }

    private Iterable<CSVRecord> getRecord(String filename) {
        Iterable<CSVRecord> Records = null;
        try {
            Reader FileReader = new FileReader(filename);
            Records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(FileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Records;
    }

    public void setDateRange(String StartDate, String EndDate) {
        try {
            StartDateTime = formatter.parse(StartDate);
            EndDateTime = formatter.parse(EndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getTradeRecords() {
        CSVParser Records = null;
        try {
            Reader FileReader = new FileReader(TradeFile);
            Records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(FileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : Records) {
            Date TradeDateTime = null;
            try {
                TradeDateTime = formatter.parse(record.get("TradeDtTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            items.add(record);

        }
    }

    public void filterByDateRange(Boolean flag) {
        Iterable<CSVRecord> InstRecords = getRecord(InstFile);
        getTradeRecords();

        System.out.println("Test Run : ----------------");

        InstRecords.forEach((CSVRecord instRecord) -> {
            String InstId = (instRecord.get("instid"));


            final Date[] TradeDtTime = new Date[1];
            String InstName = (instRecord.get("instname"));
            items.stream()
                    .filter(s -> s.get("InID").equals(InstId))
                    .filter(s -> {
                        try {
                            TradeDtTime[0] = formatter.parse(s.get("TradeDtTime"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (flag) {
                            return (TradeDtTime[0].after(StartDateTime) && TradeDtTime[0].before(EndDateTime));
                        } else {
                            return !(TradeDtTime[0].after(StartDateTime) && TradeDtTime[0].before(EndDateTime));
                        }

                    })
                    .forEach(s -> {
                        System.out.println("InID: "+s.get("InID")+" Quantity:   "+s.get("qty"));
                    });
        });
    }
}