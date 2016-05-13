package sizeOfWord;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapWordSize extends MapReduceBase implements Mapper<Text , IntWritable , IntWritable ,Text > {

	
	private Text word = new Text ();
	
	@Override
	public void map(Text key, IntWritable values,
			OutputCollector<IntWritable ,Text> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		String val= values.toString().trim();
		StringTokenizer tokanizer = new StringTokenizer(val);
		
		while (tokanizer.hasMoreTokens()){
			String Separeteword = tokanizer.nextToken();
			if (Separeteword.length() > 0){
				IntWritable	 leght = new IntWritable (Separeteword.length());
				
				 word.set(Separeteword);
				Output.collect(leght, word);
			}
		}
		
	}

}
