package fileComparision;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class FileComparisionReduce extends MapReduceBase implements Reducer<LongWritable , Text, LongWritable, Text>{

	@Override
	public void reduce(LongWritable key, Iterator<Text> value,
			OutputCollector<LongWritable, Text> output, Reporter report)
			throws IOException {
		
/* Assume  input text is 1, hi how are you? what are u doing 
 * 					2, I am good and doing good 
 * So String[2] = (contain)  hi how are you? what are u doing		

 
			*/ 	String [] line =new  String [2];
					int i=0;
				while (value.hasNext()){
					line[i] = value.next().toString();
					
					}
					
					if (line[0].equals(line[1])){
						output.collect(key, new Text("same"));
					}
					else {
						output.collect(key, new Text(line[0]+"**vs**"+line[1]));
					}
				}
			
			}
