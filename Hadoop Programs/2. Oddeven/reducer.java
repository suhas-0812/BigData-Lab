package oddeven;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
    public void reduce(Text key, Iterator<IntWritable> value, OutputCollector<Text, IntWritable> output, Reporter r) throws IOException{
        int sum=0, count=0;
        while (value.hasNext()) {
            sum+=value.next().get();
            count++;
        }
        output.collect(new Text("Sum of "+key+" numbers: "), new IntWritable(sum));
        output.collect(new Text("Count of "+key+" numbers: "), new IntWritable(count));
    }
}
