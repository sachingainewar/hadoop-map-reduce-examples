package WordCount.Pack;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;



// output of mapper is  i/p of Reducer. out of mapper is like  [hi][1,1,1,1,1,2], whereas hi turns into key and [1,1,1,1,1..] turns into values
public class WordReducer extends MapReduceBase implements Reducer<Text, IntWritable , Text , IntWritable >{

	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values,
			OutputCollector<Text, IntWritable> output, Reporter outputDirectory)
			throws IOException {
	
// Get teh sum of all values for each key . ie  numbr of times hi come 
		
		int count =0;
		while (values.hasNext()){
			IntWritable i = values.next();  /// Store teh values in IntWritable veriable 
			
			count  = count + i.get();
		}
		output.collect(key, new IntWritable (count) );
	}

}
