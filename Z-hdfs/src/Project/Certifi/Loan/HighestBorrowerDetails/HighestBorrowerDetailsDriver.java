package Project.Certifi.Loan.HighestBorrowerDetails;

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

public class HighestBorrowerDetailsDriver  extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2 ){
			System.out.println("Enter correct input details ");
			return -1;
		}
/// create object for JonConf class 
		JobConf conf = new JobConf();
		
// set a job name 
		conf.setJobName("Get details of higest Borrower ");
		conf.setJarByClass(HighestBorrowerDetailsDriver.class);
		
//set a input and out put file type 
		
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
		
// Set input and output file formate 
		FileInputFormat.setInputPaths(conf, new Path (arg0[0]));
	// delete if out dir is already exit 
		Path OutputDir= new Path (arg0[1]);
		FileOutputFormat.setOutputPath(conf, OutputDir);
		
// Set Mapper and reducer 
		conf.setMapperClass(HighestBorrowerDetailsMapper.class);
		conf.setReducerClass(HighestBorrowerDetailsReducer.class);
		
// Submit job 
		JobClient.runJob(conf);
		return 0;
	}

	public static void main(String[] args) throws Exception {
// Exit form job 
		int sysExit= ToolRunner.run(new HighestBorrowerDetailsDriver(), args);
		System.exit(sysExit);
	}


}
