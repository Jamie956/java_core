package com.jamie.departjson;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;


public class MyOutPutFormat extends TextOutputFormat<NullWritable, Text>{
    @Override
    public Path getDefaultWorkFile(TaskAttemptContext context, String extension) throws IOException{
        FileOutputCommitter committer = (FileOutputCommitter) getOutputCommitter(context);
        return new Path(committer.getWorkPath(), getOutputName(context));
    }
}