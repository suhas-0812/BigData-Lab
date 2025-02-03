package employee;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
        String [] line = value.toString().split(",");
        String gender = line[3];
        Double salary = Double.parseDouble(line[4]);
        output.collect(new Text(gender), new DoubleWritable(salary));
    }
}
