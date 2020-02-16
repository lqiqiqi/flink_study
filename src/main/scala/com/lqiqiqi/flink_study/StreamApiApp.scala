package com.lqiqiqi.flink_study

import com.lqiqiqi.flink_study.util.MyKafkaUtil
import com.lqiqiqi.flink_study.util.MyKafkaUtil
import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala.DataStream

object StreamApiApp {
  def main(args: Array[String]): Unit = {
    val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val kafkaConsumer  =MyKafkaUtil.getConsumer("GMALL_STARTUP")

    val dstream: DataStreamSource[String] = environment.addSource(kafkaConsumer)

    dstream.print()

    environment.execute()
  }

}
