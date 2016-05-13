package fileComparision;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class FileComparisionMapper2 extends MapReduceBase implements Mapper <LongWritable, Text , LongWritable, Text>{

	@Override
	public void map(LongWritable key, Text value, OutputCollector<LongWritable, Text> Output,
			Reporter report ) throws IOException {
		Output.collect(key, value);
	}

}
