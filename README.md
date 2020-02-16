This is a template for flink learner. It builds a Kafka producer and flink connector as consumer locally. You can define custom data and learn to use flink transformation operator and debug it locally.

## How to use

1. start zookeeper and Kafka server in your virtual machine

   ```
   bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
   
   bin/kafka-server-start.sh  config/server.properties
   ```

2. change server and its host in properties according to your VM in ``.\src\main\java\com\lqiqiqi\flink_study\KafkaCustomProducer.java``and``.\src\main\java\com\lqiqiqi\flink_study\ReadfromKafka.java``

   ```
   props.put("bootstrap.servers", "node1:9092");//kafka集群，broker-list
   ```

3. put your data in ``.\src\main\resources\raw_data.csv``

4. run``KafkaCustomProducer`` to produce data and read data by ``ReadfromKafka.java``

## ref

http://www.54tianzhisheng.cn/2018/01/04/Kafka/

[http://www.54tianzhisheng.cn/2019/01/06/Flink-Kafka-sink/#%E6%B7%BB%E5%8A%A0%E4%BE%9D%E8%B5%96](http://www.54tianzhisheng.cn/2019/01/06/Flink-Kafka-sink/#添加依赖)

https://github.com/jyj019/flinkDemo