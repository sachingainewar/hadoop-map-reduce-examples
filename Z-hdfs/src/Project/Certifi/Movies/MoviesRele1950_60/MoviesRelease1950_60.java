package Project.Certifi.Movies.MoviesRele1950_60;

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

public class MoviesRelease1950_60 extends Configured implements Tool{


	
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		if(arg0.length < 2){
			System.out.println("Please entre correct iput and output");
			return -1;
		}
		
/// Configure JobConf
		JobConf conf = new JobConf();
		conf.setJobName("Moveies_release_from_1950_60");
		conf.setJarByClass(MoviesRelease1950_60.class);
		
// Type of file format
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(IntWritable.class);
		conf.setOutputKeyClass(IntWritable.class);
		conf.setOutputValueClass(Text.class);
		
//type of mapper and reducer 
		conf.setMapperClass(MoviesRelease1950_60Mapper.class);
		conf.setReducerClass(MoviesRelease1950_60Reducer.class);
		
//set file format 
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		Path  OutputDir = new Path(arg0[1]);
		OutputDir.getFileSystem(conf).deleteOnExit(OutputDir);
		FileOutputFormat.setOutputPath(conf, OutputDir);
		
		
// submit job
		JobClient.runJob(conf);
		
		return 0;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int systemExit= ToolRunner.run(new MoviesRelease1950_60(), args);
		System.exit(systemExit);
	}
}
