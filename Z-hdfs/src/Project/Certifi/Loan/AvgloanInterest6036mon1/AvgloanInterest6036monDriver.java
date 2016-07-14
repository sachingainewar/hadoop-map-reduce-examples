package Project.Certifi.Loan.AvgloanInterest6036mon1;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AvgloanInterest6036monDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
// Check if input parameters are correctly passed
		if (arg0.length < 2){
			System.out.println("Please entre a correct input parameters");
			return -1;
		}
		
// Configured  jobconf 
		JobConf conf = new JobConf();
// Set Job name 
		conf.setJobName("Avg Interest on 60 month and  36mon");
		conf.setJarByClass(AvgloanInterest6036monDriver.class);
		
	// set mapper out and reducer output type 
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		
// set file type 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		Path OutputDir = new Path(arg0[1]);
		FileOutputFormat.setOutputPath(conf,OutputDir);

// set Mapper and Reducer 
		
		conf.setMapperClass(AvgloanInterest6036monMapper.class);
		conf.setReducerClass(AvgloanInterest6036monReducer.class);
		
// submit jobs 
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int SysExit= ToolRunner.run(new AvgloanInterest6036monDriver(), args);
		System.exit(SysExit);
	}


}
