package Project.Certifi.Airline.ActiveAirlineUS;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class ActiveAirlineUSMapper extends MapReduceBase implements Mapper <LongWritable, Text, Text, IntWritable>{

// ID,Name    ,Alis,AT,IC,callsign,country		,active
//	2,135 Airways,\N,,GNL,GENERAL,United States,N
//	0,1         ,2 ,3, 4 ,5      , 6           , 7
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
 		
		String[] line= value.toString().split(",");
		if (line[7].equalsIgnoreCase("Y") && line[6].equalsIgnoreCase("United States")){
			System.out.println(line[1]+"Name of Airline in US");
			output.collect(new Text(line[1]), new IntWritable(1));
			
		}
		
		
	}

}
