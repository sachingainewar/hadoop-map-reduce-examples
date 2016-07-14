package Project.Certifi.Airline.ActiveAirlineUS;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ActiveAirlineUSDriver extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
// Check ipput and output parameters are correctly passs 
		
		if (arg0.length < 2){
			System.out.println("Please enter a correct input and out ");
			return -1;
 		}
		
// Set the enviroment with job config
		JobConf conf = new JobConf();
// Set job name 
		conf.setJobName("Active_Airline_in_US");
		conf.setJarByClass(ActiveAirlineUSDriver.class);
		
		conf.setMapperClass(ActiveAirlineUSMapper.class);
		conf.setReducerClass(ActiveAirlineUSReducer.class);
		
// Set File format
		FileInputFormat.setInputPaths(conf,new Path(arg0[0]));
// set output folder if it is already exit 
		Path outputDir= new Path(arg0[1]);
		outputDir.getFileSystem(conf).deleteOnExit(outputDir);
		FileOutputFormat.setOutputPath(conf,outputDir);
		
		
// Set input and output tpye iof file system 
		
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
//Submit a job 
		JobClient.runJob(conf);
		
		return 0;
	}
public static void main(String[] args) throws Exception{
	int exitSystem = ToolRunner.run(new ActiveAirlineUSDriver(), args);
	System.exit(exitSystem);
}
	
	
	
}
