package Project.Certifi.Airline.HighestAirportInCountry;

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

import Project.Certifi.Airline.IndianAirportCount.DriverIndianAirport;

public class HighestAirportDriver extends Configured implements Tool{

 

	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length <2 ){
			System.out.println("Please enter a correct input and output ");
			return -1;
		}

// Concfigured env via jobconf
		JobConf conf = new JobConf();
// name of job 
		conf.setJobName("Country_with_Highest_Number_of_Airport");
		conf.setJarByClass(HighestAirportDriver.class);
		
// set a file format of input and output file 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
// Delete out directory if it already present 
		Path Outdirectory = new Path(arg0[1]);
		Outdirectory.getFileSystem(conf).deleteOnExit(Outdirectory);
		FileOutputFormat.setOutputPath(conf,new Path(arg0[1] ));
		
//	set a input and out data type 
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
// create a mapper and reducer class 
		conf.setMapperClass(HighestAirportMapper.class);
		conf.setReducerClass(HighestAirportReducer.class);
		
		JobClient.runJob(conf);
		
		return 0;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Exit to system after the a job is done 	
		int Systemexit= ToolRunner.run(new HighestAirportDriver(), args);
		System.exit(Systemexit);
		
	}
}
