package sizeOfWord;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DriverWordSize extends Configured implements Tool {



	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2){
			System.out.println("Please Pass the input and output file path correctly ");
		return -1;
		}
		
// All Environment settting is put in ConfJob class So create a instance of the class
		
		JobConf conf = new JobConf();
		
//Set Job name  
		conf.setJobName("Group word by their lenght");
		
// set type of file and path 
	 FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
	 FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
	 
// Set type of file formate for mapper 
	 conf.setMapOutputKeyClass(Text.class);
	 conf.setMapOutputValueClass(IntWritable.class);
	 conf.setOutputKeyClass(Text.class);
	 conf.setOutputValueClass(IntWritable.class);
	 
//Set mapper and rEducer class 
	 conf.setMapperClass(MapWordSize.class);
	 conf.setReducerClass(ReduceWordSize.class);
	 
//Submit the job
	 JobClient.runJob(conf);
	 
	 
return 0;
	}

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int exitCode = ToolRunner.run(new DriverWordSize(), args);
		System.exit(exitCode);
	}
	
}
