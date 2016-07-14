package Project.Certifi.Loan.HigherPaidBorrower1;

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

public class HigerInterestPaidBorrowerDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
// Check if input parameters are corretcly passed 
		if (arg0.length < 2 ){
			System.out.println("Please enter the a coorect input parameters");
			return -1;
		}
// set Configureation 
	JobConf conf = new JobConf();
/// set job name 
	conf.setJobName("Higer Interest Paid Borrower more than 1000");
	conf.setJarByClass(HigerInterestPaidBorrowerDriver.class);
	
/// Set input and out File Path
	FileInputFormat.setInputPaths(conf, new Path (arg0[0]));
	Path OutputDir = new Path(arg0[1]);
	OutputDir.getFileSystem(conf).deleteOnExit(OutputDir);
	FileOutputFormat.setOutputPath(conf, OutputDir);
	
// set outpout of Mapper and rEducer 
	
	conf.setMapOutputKeyClass(IntWritable.class);
	conf.setMapOutputValueClass(IntWritable.class);
	conf.setOutputKeyClass(Text.class);
	conf.setOutputValueClass(IntWritable.class);
	
// set mapper andf reducer 
	 conf.setMapperClass(HigerInterestPaidBorrowerMapper.class);
	 conf.setReducerClass(HigerInterestPaidBorrowerReducer.class);
	
	 
// Submit a job 
	 
	 JobClient.runJob(conf);
	 
		return 0;
	}

	public static void main(String[] args) throws Exception {
	int sysExit = ToolRunner.run(new HigerInterestPaidBorrowerDriver(), args);
	System.exit(sysExit);
	

	}


}
