package WordCount.Pack;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.WordCount;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import MaximumTemperature.MaxTemperatureOFYear;


//Driver class is basically configiration class
public class Driver extends Configured implements Tool {
// Tool method is take care of input and output directory. Since to run Hdfs command is --> hadoop jar jarname.jar package.classname i/p /outputdir 
// so commandline orguments is main(String[] args) so i/p and o/pdir as passing as orguments 
// So if args is less than 2 hdfs will not run 
	
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2){
			System.out.println("Please give input and out driectory properly ");
			return -1; 
// Regarding Return, if return status 0 means the program succeeded.  And tatus different from 0 means the program exited due to error or anomaly.
			}
// all configuration method is define in JobConf class so creating a Object for 
		
		JobConf conf = new JobConf(Driver.class);

//create a job name 
		conf.setJobName("package.Wordcount");
		conf.setJarByClass(Driver.class); //to remove the 

		
//set inputPath and output directory --. main(i/p o/p) -> So connvert the string type to Path type. So that hadoop recognise as Input paths . And setting a "conf" as referance for JobConf class
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
//Set outputPath for output directory ...
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
//Set mapper class and set reducer class. Create mapper class of name WordMapper and reducer class with name WordReducer
		conf.setMapperClass(WordMapper.class);
		conf.setReducerClass(WordReducer.class);
		
// Define what output key we get and what value we get . here since mapper is output is of text type. so 
		
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		
//Submitting the class 
		JobClient.runJob(conf);
		
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int exitcode = ToolRunner.run(new WordCount(), args);
		System.exit(exitcode);

	}

	
}
