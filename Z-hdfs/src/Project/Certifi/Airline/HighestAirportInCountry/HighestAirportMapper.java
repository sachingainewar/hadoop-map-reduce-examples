package Project.Certifi.Airline.HighestAirportInCountry;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HighestAirportMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

///    ID,name,city    , country      , IA , IC , Latitu  , Longit ,Al, T,DST, Tz 
//[1]- 2,Madang,Madang,Papua New Guinea,MAG,AYMD,-5.207083,145.7887,20,10,U,Pacific/Port_Moresby
//	   0,1,    2,      3              ,  4,  5 , 6       ,  7     , 8, 9,10,11
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> Output, Reporter reportDir)
			throws IOException {
		// TODO Auto-generated method stub
		
// convert value into string and split by ","	and country as key . means number of times same country is present that much time new airport is there. 	
		String[] atrib= value.toString().split(",");
		
			Output.collect(new Text(atrib[3]),new IntWritable(1));
		
 	}


}
