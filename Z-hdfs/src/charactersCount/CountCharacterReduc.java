package charactersCount;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class CountCharacterReduc extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

	   private IntWritable result = new IntWritable();

	
//hi -2, sachin-6, i-1,am -2  ----> output is in this format	
	
//[2] --[hi,is ]	
	@SuppressWarnings("unchecked")
	@Override
	public void reduce(Text key, Iterator<IntWritable> values,
			OutputCollector<Text, IntWritable> Output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		
		
	    for (IntWritable val : (Iterable<IntWritable>)values) {
	    	
	    	Script developed by 
	    }

	}
	
}	
	     

	


