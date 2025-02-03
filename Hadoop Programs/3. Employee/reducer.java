package employee;
import java.io.*;
import java.util.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
    public void reduce (Text key, Iterator<DoubleWritable> value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
        double count=0, sum=0;
        while(value.hasNext()){
            sum+=value.next().get();
            count++;
        }
        output.collect(new Text("Average Salary of "+key+" employees: "), new DoubleWritable(sum/count));
        output.collect(new Text("Count of "+key+" employees: "), new DoubleWritable(count));
    }    
}
