package MaximumTemperature;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import MaximumTemperature.MaxTemperatureOFYearMap;
import MaximumTemperature.MaxTemperatureOFYearReduce;

public class MaxTemperatureOFYear extends Configured implements Tool {


	

	@Override
	public int run(String[] arg0) throws Exception {

// check input and out is parameters are passed correctly 
		if (arg0.length < 2){
			System.out.println("Please pass a correct input and output paramerters");
			return -1;
			
		}
		
// JobConfig is class which manage the all the evn so set it.
		JobConf conf= new JobConf();
// Set teh name of job 
		conf.setJobName("Maximum Temperature of each Year");
		conf.setJarByClass(MaxTemperatureOFYear.class);

		
		
		
		
		
// Set teh path of input and output file 
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf,new Path(arg0[1]));
		
// set the type of file 
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(IntWritable.class);
		
// set Mapper and REducer class
		conf.setMapperClass(MaxTemperatureOFYearMap.class);
		conf.setReducerClass(MaxTemperatureOFYearReduce.class);
		
// Submit the job
		JobClient.runJob(conf);
		
		return 0;
	}
public static void main(String[] args) throws Exception {
	
	int ExitSystem = ToolRunner.run(new MaxTemperatureOFYear(), args);
	
	System.exit(ExitSystem);

	}
}
