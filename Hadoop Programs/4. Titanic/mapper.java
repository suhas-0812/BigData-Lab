package titanic;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
    public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
        String [] line = value.toString().split(",");
        String survived = line[1];
        String pclass = line[2];
        String gender = line[4];
        double age = Double.parseDouble(line[5]);

        if (survived.equals("1")){
            output.collect(new Text("Survived in class: "+pclass), new DoubleWritable(1));
        }
        else{
            output.collect(new Text(gender), new DoubleWritable(age));
        }
    }
}
