package Project.Certifi.Movies.MoviesRele1950_60;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MoviesRelease1950_60Mapper extends MapReduceBase implements Mapper <LongWritable, Text, Text,IntWritable>{

	
	
//	id,movie name                  ,relese,rat,hr
//	--------------------------------------------------
//	1,The Nightmare Before Christmas,1993,3.9,4568
//	0, 			1					,2   ,3  ,4
	
	
	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
			
		int MovieCount =0;

// Splite line into words and set		
		String[] line= value.toString().split(",");
		int years =Integer.parseInt(line[2].trim());
		
		if (years >= 1950   && years <= 1960){
			System.out.println("Movies --> "+line[1]);
			MovieCount ++;
			output.collect(new Text(line[1]), new IntWritable(MovieCount));

		}

	}
	

}
