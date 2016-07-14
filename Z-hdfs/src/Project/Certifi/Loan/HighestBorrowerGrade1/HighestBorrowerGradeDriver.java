package Project.Certifi.Loan.HighestBorrowerGrade1;

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

public class HighestBorrowerGradeDriver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
// Check input paramaters are correct 
		if (arg0.length < 2 ){
			System.out.println("Please enter a correct Details of input parameters");
			return -1;
		}
		
// Set configuration 
		JobConf conf = new JobConf();
// set a job name 
		conf.setJobName("Grade Who borrowered highest amount ");
		conf.setJarByClass(HighestBorrowerGradeDriver.class);
		
// set a Type of file system 
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		Path Outputdir = new Path(arg0[1]);
		FileOutputFormat.setOutputPath(conf, Outputdir);
	
		
// Set mapper and reducer 
		conf.setMapperClass(HighestBorrowerGradeMapper.class);
		conf.setReducerClass(HighestBorrowerGradeReducer.class);
		
//s et mapper and reducer output 
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
//submit a job 
		
		JobClient.runJob(conf);
		
		
		
		return 0;
	}
	/**
}

	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		int sysExcit=	ToolRunner.run(new HighestBorrowerGradeDriver(), args);
		System.exit(sysExcit);
	}
}
