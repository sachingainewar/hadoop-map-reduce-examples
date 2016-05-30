package Project.Certifi.Airline.IndianAirportCount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class IndianAirportReducer extends MapReduceBase implements Reducer<Text, IntWritable,Text ,IntWritable >{

// [Sahara [1,1,1,2,] Mumbai[1,1,2,2].....
	
	@Override
	public void reduce(Text Key, Iterator<IntWritable> values,
			OutputCollector<Text, IntWritable> Output, Reporter ReportDir)
			throws IOException {
		// TODO Auto-generated method stub
		
		
		Text AirlineName = new Text();
		int TotalAirport =0;
		while (values.hasNext()){
			int a = (values.next()).get();
		    if (a<5) {
		    	TotalAirport++;
		    }
			
		    System.out.println(AirlineName);
			Output.collect(new Text (Key), new IntWritable(TotalAirport));
		}
		
		
		
	}

	
	
}
