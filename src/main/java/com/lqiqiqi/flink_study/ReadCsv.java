package com.lqiqiqi.flink_study;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.lqiqiqi.flink_study.KafkaCustomProducer.randInt;

public class ReadCsv {
    
    public static void main(String[] args) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(".\\src\\main\\resources\\raw_data.csv"));
        String row;
        String[] dataArray = new String[0];
        List<String[]> records = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            dataArray = row.split(",");
            records.add(dataArray);
            // do something with the data
        }

        for (int i = 0; i < records.size(); i++) {
//            System.out.println(Arrays.toString(records.get(i)));
            System.out.println(Arrays.toString(records.get(randInt(1, records.size()-1))));
        }

    }
}
