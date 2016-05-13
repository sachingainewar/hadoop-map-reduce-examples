package PATENT;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class patentReduce extends MapReduceBase implements Reducer<IntWritable, IntWritable , IntWritable , IntWritable >{

	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> values,
			OutputCollector<IntWritable, IntWritable> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		int sum =0;
		
		while (values.hasNext()){
				sum++;
		
				Output.collect(key, new IntWritable (sum));
		}
	}

}
