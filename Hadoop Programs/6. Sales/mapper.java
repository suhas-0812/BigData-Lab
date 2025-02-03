package sales;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter r) throws IOException{
        String [] line = value.toString().split(",");
        String product = line[1];
        int sales = Integer.parseInt(line[2]);
        String card = line[3];
        String country = line[7];
        output.collect(new Text("Country : "+country), new IntWritable(sales));
        output.collect(new Text("Product : "+product), new IntWritable(1));
        output.collect(new Text("Card Type : "+card), new IntWritable(1));
    }
}
