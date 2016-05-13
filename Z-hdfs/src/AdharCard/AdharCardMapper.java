package AdharCard;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class AdharCardMapper extends MapReduceBase  implements  Mapper<IntWritable, Text , IntWritable , Text>{

	@Override
	public void map(IntWritable key, Text values,
			OutputCollector<IntWritable, Text> result, Reporter repot)
			throws IOException {
		
		String val= values.toString();
		
		StringTokenizer tokanizer = new StringTokenizer(val);
		
			while (tokanizer.hasMoreTokens()){
				String  token1 = tokanizer.nextToken();
				int k= Integer.parseInt(token1);
				
				String token2 = tokanizer.nextToken();
				
			}
		
		// TODO Auto-generated method stub
		
	}
	
	

}
