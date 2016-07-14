package Project.Certifi.Movies.MoviesRele1950_60;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class MoviesRelease1950_60Reducer extends MapReduceBase implements Reducer<Text , IntWritable, IntWritable, Text>{

	
//[shole]-[56], maa-[57], etc	
	@Override
	public void reduce(Text key, Iterator<IntWritable> values,
			OutputCollector<IntWritable, Text> output, Reporter report)
			throws IOException {
		// TODO Auto-generated method stub
		
		
		String moiveName =null;
		
		while (values.hasNext()){
		
			int a =values.next().get();
			if (a > 500){
				moiveName=key.toString();
				System.out.println("movies count "+moiveName);
			}
		}
		output.collect( new IntWritable(),new Text("movies detween 1950 and 1960-->"+moiveName));
			
		}

}
