package charactersCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class CountCharactersMap extends MapReduceBase implements Mapper <LongWritable , Text, Text , IntWritable > {

	
// "hi this sachin " --> [0 ]-key and "hi this sachin" --> Values	
	
	@Override
	public void map(LongWritable key, Text values,
			OutputCollector<Text, IntWritable> Output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		
// Conversion of valuyes to string 
		String s = values.toString();
// Split word that recognice as as space 
		
		for (String word : s.split(" ")){
			if (word.length() > 0 ) {
				
				
				Output.collect(new Text(word), new IntWritable(word.length()));
			}
			
		}
		
	}

	
}
