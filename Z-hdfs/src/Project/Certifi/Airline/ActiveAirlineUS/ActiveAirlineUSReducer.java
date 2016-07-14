package Project.Certifi.Airline.ActiveAirlineUS;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ActiveAirlineUSReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

	
// [Sahar airline][1,1,2,2,3], Mumbai airpot -[1,1,1,2]	
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		Text AirlineName = new Text();
		int TotalAirportCount =0;
 		while (value.hasNext()){
			int a = (value.next()).get();
		    if (a<100) {
		    	TotalAirportCount++;
				output.collect(new Text (AirlineName),new IntWritable(TotalAirportCount));

		    }
			
		}
 
	}

}
