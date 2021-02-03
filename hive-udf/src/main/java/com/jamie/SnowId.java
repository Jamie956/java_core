package com.jamie;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;

//表示函数返回值不重复
@UDFType(deterministic = false)
public class SnowId extends UDF {
    public long evaluate() {
        return IDGenerator.nextId();
    }
}
