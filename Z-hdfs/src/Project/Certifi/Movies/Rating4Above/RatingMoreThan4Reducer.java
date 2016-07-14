package Project.Certifi.Movies.Rating4Above;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import com.google.protobuf.ByteString.Output;

public class RatingMoreThan4Reducer extends MapReduceBase implements Reducer<IntWritable, IntWritable,Text, Text>{
	
	String totalMovie=null;
	@Override
	public void reduce(IntWritable key, Iterator<IntWritable> value,
			OutputCollector<Text, Text> ouput, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		while (value.hasNext()){
			int a =value.next().get();
			if (a>0){
				totalMovie=value.toString();
			}
			ouput.collect(new Text("rated total movies->  "+key), new Text(totalMovie));
		}
		
	}
	

}
