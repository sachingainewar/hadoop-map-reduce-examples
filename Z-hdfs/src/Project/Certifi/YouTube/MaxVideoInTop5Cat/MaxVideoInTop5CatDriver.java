package Project.Certifi.YouTube.MaxVideoInTop5Cat;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MaxVideoInTop5CatDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
// check for input parameters 
		if (arg0.length <2 ){
			System.out.println("Please entre a corrcet input ");
			return -1;
		}
		
// configured conf 
	JobConf conf = new JobConf();
// set name 
		conf.setJobName("Max numbr of video on top 5 category ");
		conf.setJarByClass(MaxVideoInTop5CatDriver.class);
		
// set input out path 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		Path OutputDir = new Path(arg0[1]);
		FileOutputFormat.setOutputPath(conf,OutputDir);
	
// Set Mapper and Reduce 
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(IntWritable.class);
		
// Set mapper and reducer 
		conf.setMapperClass(MaxVideoInTop5CatMapper.class);
		conf.setReducerClass(MaxVideoInTop5CatReducer);
	///Submit job
		
		JobClient.runJob(conf);
		
		return 0;
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		int Sysexit= ToolRunner.run(new MaxVideoInTop5CatDriver(), args);
			System.exit(Sysexit);
		
	}


}
