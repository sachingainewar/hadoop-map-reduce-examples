package PATENT;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class patentMap extends MapReduceBase implements Mapper <IntWritable , IntWritable, IntWritable, IntWritable>{

	
	IntWritable k= new IntWritable();
	IntWritable v = new IntWritable();
	
	@Override
	public void map(IntWritable key, IntWritable values,
			OutputCollector<IntWritable, IntWritable> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		String val = values.toString();
		StringTokenizer tokanizer = new StringTokenizer(val);
		
		while (tokanizer.hasMoreTokens()){
			String pat = tokanizer.nextToken();
			int pat1= Integer.parseInt(pat);
			k.set(pat1);
			String subPat = tokanizer.nextToken();
			int subPat1 = Integer.parseInt(subPat);
			v.set(subPat1);
			
			Output.collect(k, v);
		}
		
	}

}
