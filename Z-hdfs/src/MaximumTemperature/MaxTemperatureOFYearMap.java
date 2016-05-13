package MaximumTemperature;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MaxTemperatureOFYearMap extends MapReduceBase implements Mapper <IntWritable, IntWritable, IntWritable, IntWritable>{

	
	IntWritable k = new IntWritable ();
	IntWritable v = new IntWritable();
	@Override
	public void map(IntWritable kay, IntWritable value,
			OutputCollector<IntWritable, IntWritable> Output, Reporter Report)
			throws IOException {
		// TODO Auto-generated method stub
	
		String val= value.toString();
		StringTokenizer tokanizer = new StringTokenizer(val);
		
		while(tokanizer.hasMoreTokens()){
			String tokan1 = tokanizer.nextToken();
			int key =Integer.parseInt(tokan1);
			k.set(key);
			
			
			String tokan2 = tokanizer.nextToken();
			int valu =Integer.parseInt(tokan2);
			v.set(valu);
			Output.collect(k, v);
		}
		
	}

}
