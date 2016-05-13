package AdharCard;

import org.apache.hadoop.conf.Configuration;
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

public class AdharDriver extends Configured implements Tool {

	/**
	 * @param args
	 */

	@Override
	public int run (String[] args) {
///Check input and out put parameters are passed correctly 
		if (args.length < 2 ){
			System.out.println("Please put correct input and output parameters");
			return -1;
		}
		
//set jobconf class as evn setting is here ony 
		JobConf conf = new JobConf();
		
//set the name of job
		conf.setJobName("AdharCard Analysis");
		
// set the input and put paths
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		

		
// Set inpout type of file format
		
		conf.setMapOutputKeyClass(IntWritable.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
		/// set mapper and reducer 
				conf.setMapperClass(AdharCardMapper.class);
				conf.setReducerClass(AdharCardReducer.class);
				
				
// Submit the jiob
		
		JobClient.runJob(conf);
		return 0;
	}




	public static void main(String[] args) throws Exception {
		int SystemExit= ToolRunner.run(new AdharDriver(), args);
		System.exit(SystemExit);
		
	}




	
}
