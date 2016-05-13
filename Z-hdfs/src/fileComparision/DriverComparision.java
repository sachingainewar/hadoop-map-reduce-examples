package fileComparision;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.lib.ChainMapper;
import org.apache.hadoop.mapred.lib.ChainReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import MaximumTemperature.MaxTemperatureOFYear;

public class DriverComparision extends Configured implements Tool{
	
	
	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2){
			System.out.println("Please specify the intput and poutput path correctly ");
			return -1;
			}
		
		JobConf conf = new JobConf(true);
		
		
		conf.setJobName("Comaprision of 2 file ");
		conf.setJarByClass(MaxTemperatureOFYear.class);

		
		JobConf Mapper1 = new JobConf(false);
		ChainMapper.addMapper(conf, FileComparisionMapper1.class, LongWritable.class, Text.class, LongWritable.class, Text.class, true, Mapper1);
		
		JobConf Mapper2 = new JobConf(false);
		ChainMapper.addMapper(conf, FileComparisionMapper2.class, LongWritable.class, Text.class, LongWritable.class, Text.class, true, Mapper2);
		
		JobConf Reduc = new JobConf(false);
		ChainReducer.setReducer(conf, FileComparisionReduce.class, LongWritable.class, Text.class, LongWritable.class, Text.class, true,  Reduc);
		
		
	/*	conf.setMapperClass(FileComparisionMapper1.class);
		conf.setReducerClass(FileComparisionReduce.class);*/
		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		conf.setMapOutputKeyClass(LongWritable.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(LongWritable.class);
		conf.setOutputValueClass(Text.class);
		
		
		JobClient.runJob(conf);
		
		return 0;
	}


	public static void main(String[] args) throws Exception {
		int systemexit = ToolRunner.run(new DriverComparision(), args);
			System.exit(systemexit);
	}



}
