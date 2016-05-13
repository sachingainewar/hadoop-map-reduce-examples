package Tempareture;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HotdayColdDayReduce extends MapReduceBase implements Reducer<IntWritable , Text, IntWritable , Text>{

	@Override
	public void reduce(IntWritable key, Iterator<Text> values,
			OutputCollector<IntWritable, Text> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		while (values.hasNext()){
			String val= values.next().toString();
			Output.collect(key, new Text(val));

		}

	}

}
