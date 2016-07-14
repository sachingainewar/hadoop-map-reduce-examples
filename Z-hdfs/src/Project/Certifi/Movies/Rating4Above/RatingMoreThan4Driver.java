package Project.Certifi.Movies.Rating4Above;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class RatingMoreThan4Driver extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2){
			System.out.println("Please entre correct inputs");
				return -1;
		}
		
// Configure Job evnitrnment 
		JobConf conf = new JobConf();
// set job name 
		conf.setJobName("Number of movies rating is more than 4");
		conf.setJarByClass(RatingMoreThan4Driver.class);
	
// set output an dinput diretcory 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		Path OutputDir = new Path(arg0[1]);
		
		FileOutputFormat.setOutputPath(conf, OutputDir);
		
// set out ype of file 
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		
// set mapper and reducer 
		conf.setMapperClass(RatingMoreThan4Mapper.class);
		conf.setReducerClass(RatingMoreThan4Reducer.class);
		
// submit a job 
		JobClient.runJob(conf);
		
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
			int sysExit= ToolRunner.run(new RatingMoreThan4Driver(), args);
			System.exit(sysExit);
	}


}
