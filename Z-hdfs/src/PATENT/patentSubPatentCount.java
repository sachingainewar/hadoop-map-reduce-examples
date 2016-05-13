package PATENT;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import MaximumTemperature.MaxTemperatureOFYear;

public class patentSubPatentCount extends Configured implements Tool{

	/**
	 * @param args
	 */
	@Override
	public int run(String[] arg0) throws Exception {

		if (arg0.length < 2){
			System.out.println("Please pass correct input and output valuues ");
			return -1;
		}
/// All method is in JobConfg Class hence create an instance 
		
		JobConf conf = new JobConf(patentSubPatentCount.class);
		conf.setJobName("patent and SubPatent Count");
		conf.setJarByClass(MaxTemperatureOFYear.class);

		
// File input and out put type 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf,new Path(arg0[1] ));
		
//	set input and out file type 
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(IntWritable.class);
		
// Set Mapper and Reducer class
		
		conf.setMapperClass(patentMap.class);
		conf.setReducerClass(patentReduce.class);
		
		
// subit a job
		JobClient.runJob(conf);
		
		
		
		
		return 0;
	}

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
// Exit to system after job is done OR input otu parameters are invalie
	int exitSystem = 	ToolRunner.run(new patentSubPatentCount(), args);
	System.exit(exitSystem);
	
	}

	
}
