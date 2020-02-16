package com.lqiqiqi.flink_study;


import org.apache.kafka.clients.producer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class KafkaCustomProducer<S, S1> {

    public static int randInt(int min, int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "node1:9092");//kafka集群，broker-list
        props.put("acks", "all");
        props.put("retries", 1);//重试次数
        props.put("batch.size", 16384);//批次大小
        props.put("linger.ms", 1);//等待时间
        props.put("buffer.memory", 33554432);//RecordAccumulator缓冲区大小
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "com.lqiqiqi.flink_study.util.ObjSerializer");

        Producer<Integer, String[]> producer = new KafkaProducer<>(props);

        BufferedReader csvReader = new BufferedReader(new FileReader(".\\src\\main\\resources\\raw_data.csv"));
        String row;
        String[] dataArray = new String[0];
        List<String[]> records = new ArrayList<>();
        while ((row = csvReader.readLine()) != null) {
            dataArray = row.split(",");
            records.add(dataArray);
            // do something with the data
        }

        while(true){
            producer.send(new ProducerRecord<Integer, String[]>("first", randInt(1, records.size()-1), records.get(randInt(1, records.size()-1))));
//            producer.send(new ProducerRecord<String, String>("first", Integer.toString(i), Integer.toString(i)));
//            System.out.println(records.get(randInt(1, records.size()-1)));
        }
//        producer.close();
    }

}


