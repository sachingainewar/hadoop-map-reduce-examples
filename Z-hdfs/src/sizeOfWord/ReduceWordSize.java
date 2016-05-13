package sizeOfWord;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ReduceWordSize extends MapReduceBase implements Reducer<IntWritable, Text , IntWritable , IntWritable>{

	@Override
	public void reduce(IntWritable key, Iterator<Text> values, 
			OutputCollector<IntWritable, IntWritable> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		int counter=0;
		while(values.hasNext()){
			counter ++;
		}
		Output.collect(key,new IntWritable ( counter));
	}

}
