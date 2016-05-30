package Project.Certifi.Airline.IndianAirportCount;

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

public class DriverIndianAirport extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
// check for the input and output parameters 
		if (arg0.length > 2 ){
			System.out.println("Please pass a correct input and output parameters");
			return -1;
			}
		
//Create a object for JobConf
		JobConf conf = new JobConf();
//Name of job
		conf.setJobName("ListOfAirportInIndia");
		conf.setJarByClass(DriverIndianAirport.class);
// Set File input and output 
		FileInputFormat.setInputPaths(conf,new Path(arg0[0]));
	//delete exiting file directory
		 Path outputDir = new Path( arg0[1] );
		    outputDir.getFileSystem( conf ).delete( outputDir, true );
		    
		FileOutputFormat.setOutputPath(conf,new Path( arg0[1]));
		
//File input and output type 
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
//set mapper and reducer
		conf.setMapperClass(IndianAirportMapper.class);
		conf.setReducerClass(IndianAirportReducer.class);
		
// submit job
		JobClient.runJob(conf);
		

		return 0;
	}
	
public static void main(String [] args) throws Exception{
	
//Exit to system after the a job is done 	
	int Systemexit= ToolRunner.run(new DriverIndianAirport(), args);
	System.exit(Systemexit);
}
}
