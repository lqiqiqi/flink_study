package com.lqiqiqi.flink_study.util

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011



object MyKafkaUtil {
  val prop = new Properties()

  prop.setProperty("bootstrap.servers","node1:9092")
  prop.setProperty("group.id","gmall")

  def getConsumer(topic:String ):FlinkKafkaConsumer011[String]= {
    val myKafkaConsumer:FlinkKafkaConsumer011[String] = new FlinkKafkaConsumer011[String](topic, new SimpleStringSchema(), prop)
    myKafkaConsumer
}

}
