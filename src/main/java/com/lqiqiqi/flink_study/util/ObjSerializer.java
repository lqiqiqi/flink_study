package com.lqiqiqi.flink_study.util;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import com.lqiqiqi.flink_study.util.Utils;

public class ObjSerializer implements Serializer<Object>{
    @Override
    public void configure(Map configs, boolean isKey) {

    }
    @Override
    public byte[] serialize(String topic, Object data) {
        return Utils.Obj2Byte(data);
    }
    /*
     * producer调用close()方法是调用
     */
    @Override
    public void close() {
//        System.out.println("SerializeKafka is close");
    }

}
