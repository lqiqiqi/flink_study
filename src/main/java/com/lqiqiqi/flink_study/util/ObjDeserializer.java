package com.lqiqiqi.flink_study.util;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import com.lqiqiqi.flink_study.util.Utils;

public class ObjDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return Utils.byte2Obj(data);
    }

    @Override
    public void close() {

    }
}
