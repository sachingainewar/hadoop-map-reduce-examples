package Tempareture;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import MaximumTemperature.MaxTemperatureOFYear;

public class HotdayColdDay extends Configured implements Tool{

	
	

	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2 ){
			System.out.println("Please pass input and output parameter correctly");
			return -1;
		}
		
// Create object on JobConf class
		JobConf conf = new JobConf();
		
		conf.setJobName("HotdayColdDay of year");
		conf.setJarByClass(MaxTemperatureOFYear.class);

		
		
// File input formate 
		
		FileInputFormat.setInputPaths(conf, new Path (arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path (arg0[1]));
		
//type of file
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
//	set mapper and reducer output
		conf.setMapperClass(HotdayColdDayMap.class);
		conf.setReducerClass(HotdayColdDayReduce.class);
		
	// Submit the job 
		JobClient.runJob(conf);
		
		// TODO Auto-generated method stub
		return 0;
	}
 
	public static void main(String[] args) throws Exception {
		
		int exitSystem = ToolRunner.run(new HotdayColdDay(), args);
		System.exit(exitSystem);
	}
}
