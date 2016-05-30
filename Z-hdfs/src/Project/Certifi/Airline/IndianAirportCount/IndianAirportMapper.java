package Project.Certifi.Airline.IndianAirportCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class IndianAirportMapper extends MapReduceBase implements Mapper<LongWritable, Text,Text, IntWritable >{

//id, Airportname  ,city , Country,
//10,Thule Air Base,Thule,Greenland,THU,BGTL,76.531203,-68.703161,251,-4,E,America/Thule
// 0,    1   	   ,  2  ,    3    , 4 , 5  ,  6      , 7        ,  8, 9,10, 11
	@Override
	public void map(LongWritable key, Text values,
			OutputCollector<Text , IntWritable> output, Reporter OutputDirectory )
			throws IOException {

// Convert a vlaue into string 
			String line = values.toString();
// Spite string from ,

// [sahara 1], [mumabi 1] [pune 1].....			
				
			String[] airport= line.split(",");
			
			if (airport[3].equalsIgnoreCase("India")){
				
				System.out.println(airport[1]  +"- Airport is functional in India ");
				
				output.collect(new Text ("Airport in India ->" +airport[1]), new IntWritable(1));
				
				
			}
	}

}
