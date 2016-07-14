package Project.Certifi.Loan.AGradeBorrower;

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

public class GradeABorrowerDriver extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
	
// check if input and output are correctly passed a parametered 
		if (arg0.length < 2){
			System.out.println("Please enter correct input and output parameters ");
			return -1;
		}
		
// create object for jobConf
		JobConf conf = new JobConf();
		
// set name to job and 
		conf.setJobName("A Grade Borrower");
		conf.setJarByClass(GradeABorrowerDriver.class);

// set file system 
		
		FileInputFormat.setInputPaths(conf,new Path(arg0[0]));
		Path OutputDir = new Path(arg0[1]);		
// delete file already exit		
		OutputDir.getFileSystem(conf).deleteOnExit(OutputDir);
		FileOutputFormat.setOutputPath(conf, OutputDir );
	
// set mapper and reducer class 
		
		conf.setMapperClass(GradeABorrowerMapper.class);
		conf.setReducerClass(GradeABorrowerReducer.class);
		
// set input and output file type 
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
// Submit job 
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
//
		int Systemexit = ToolRunner.run(new GradeABorrowerDriver(), args);
		System.exit(Systemexit);
	}


}
