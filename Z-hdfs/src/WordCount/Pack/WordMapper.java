package WordCount.Pack;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

// Passing parameter as LongWritable since text is long line, 
public class WordMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text ,IntWritable  > {


//let say frist line is [1]"hi how are you ? what is problem " . now [0],[1]..etc is taken as key and "hi how are ..." is taken as values 	
	@Override
	public void map(LongWritable key, Text Value,
			OutputCollector<Text, IntWritable> Output, Reporter OutputDirectory)
			throws IOException {
		// TODO Auto-generated method stub
		
		
// converting the Values into String . ie. Text type to String 
		String s= Value.toString ();
		
// Split line into words by recognising the word with space 
		for (String word :s.split(" ")){
			if (word.length() >0 ){
// collect teh output into Output veribale define in map method 
				Output.collect(new Text(word), new IntWritable(1));
			}
		}
		
	}

	/**
	 * @param args
	 */



}
