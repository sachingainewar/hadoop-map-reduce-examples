package Project.Certifi.Movies.Rating4Above;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class RatingMoreThan4Mapper extends MapReduceBase implements
		Mapper<LongWritable, Text, IntWritable, IntWritable> {

	// 1,The Nightmare Before Christmas,1993,3.9,4568
	// 0,1 ,2 ,3,4

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<IntWritable, IntWritable> output, Reporter result)
			throws IOException {

		String[] line = value.toString().split(",");

		int counter = 0;
		if (Float.parseFloat(line[3].trim()) > 4) {
			counter ++;
			System.out.println("Movies name having rating more than 4 "+line[1]);
		}

		output.collect(new IntWritable(counter), new IntWritable(1));
	}

}
