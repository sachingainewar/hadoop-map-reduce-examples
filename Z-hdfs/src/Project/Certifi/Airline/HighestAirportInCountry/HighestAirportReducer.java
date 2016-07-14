package Project.Certifi.Airline.HighestAirportInCountry;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class HighestAirportReducer extends MapReduceBase implements Reducer<Text, IntWritable, IntWritable, Text>{

// india [1,1,1,2,2 ], US [2,1,1,1,12,]	
	
	@Override
	public void reduce(Text key, Iterator<IntWritable> value,
			OutputCollector<IntWritable, Text> Output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		int CountrySum=0;
		while(value.hasNext()){
			int a = (value.next()).get();
		    if (a<10) {
		    	CountrySum++;
		    }
			
			Output.collect( new IntWritable(CountrySum), new Text (key));
	 	}
		
	}

	
}
