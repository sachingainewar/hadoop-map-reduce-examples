package Project.Certifi.Loan.HigherAmountBorrower;

import org.apache.hadoop.conf.Configuration;
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

public class HigherLoanBorrowerDriver extends Configured implements Tool {

	
	@Override
	public int run(String[] arg0) throws Exception {
//check for input parameters 
		if (arg0.length < 2 ){
			System.out.println("Enter a correct a input parameters");
			return -1;
		}
 // Configuration processed by ToolRunner
        Configuration con = getConf();		
		
// Configureation Setting 
		JobConf conf = new JobConf(con);
// set job name 
		conf.setJobName("Borrower who borrow more than 10000");
		conf.setJarByClass(HigherLoanBorrowerDriver.class);
		
		
		//Typoe of file formate 
				conf.setMapOutputKeyClass(IntWritable.class);
				conf.setMapOutputValueClass(IntWritable.class);
				conf.setOutputKeyClass(Text.class);
				conf.setOutputValueClass(IntWritable.class);
				
				
		//set mapper and reducer 
				conf.setMapperClass(HigherLoanBorrowerMapper.class);
				conf.setReducerClass(HigherLoanBorrowerReducer.class);
						
		
		
// set input and out directory path 
		
		FileInputFormat.setInputPaths(conf, new Path (arg0[0]));
		Path OutputDir = new Path(arg0[1]);
		FileOutputFormat.setOutputPath(conf, OutputDir);
		

// submit job 
		
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int sysExit= ToolRunner.run(new HigherLoanBorrowerDriver(), args);
		System.exit(sysExit);
	}


}
