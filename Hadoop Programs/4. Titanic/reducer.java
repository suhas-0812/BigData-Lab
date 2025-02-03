package titanic;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
    public void reduce(Text key, Iterator<DoubleWritable> value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
        Double count=0.0, sum=0.0;
        while(value.hasNext()){
            sum+=value.next().get();
            count++;
        }
        if (key.toString().startsWith("Survived in class")){
            output.collect(new Text(key), new DoubleWritable(count));
        }
        else{
            output.collect(new Text(key), new DoubleWritable(sum/count));
        }
    }
}