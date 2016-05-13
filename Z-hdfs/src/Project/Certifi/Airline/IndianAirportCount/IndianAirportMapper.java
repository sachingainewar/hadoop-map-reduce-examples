package Project.Certifi.Airline.IndianAirportCount;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class IndianAirportMapper extends MapReduceBase implements Mapper<IntWritable, Text,Text, IntWritable >{

	//Input to this class is [1, 2523,Gavina,\N,,GVN,GAVINA,Spain,N]
//							  0    1   2      3 4 5   6      7     8
	@Override
	public void map(IntWritable key, Text values,
			OutputCollector<Text , IntWritable> output, Reporter OutputDirectory )
			throws IOException {

// Convert a vlaue into string 
			String line = values.toString();
// Spite string from ,

// [sahara 1], [mumabi 1] [pune 1].....			
				
			String[] contry= line.split(",");
			
			if (contry[7].equalsIgnoreCase("India") && contry[8].equalsIgnoreCase("Y")){
				
				System.out.println(contry[2]  +"- Airport is functional in India ");
				
				output.collect(new Text ("Airport in India ->" +contry[2]), new IntWritable(1));
				
				
			}
	}

}
