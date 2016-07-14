package Project.Certifi.Loan.HighestBorrowerGrade1;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class HighestBorrowerGradeMapper extends MapReduceBase implements Mapper <LongWritable, Text,Text,IntWritable>{

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> Output, Reporter report)
			throws IOException {
//0..-->10119590	11971211	11500	11500	11500	 60 months	22.90%	323.54	E	E4	Secretary	4 years	RENT	32760	Verified	13-Dec	Current	n	https://www.lendingclub.com/browse/loanDetail.action?loan_id=10119590	  Borrower added on 12/31/13 > This loan is for debt consolidation - to close credit cards, pay off other debt, finally make a dent in my total debt amount. I already have plans to close all but 2 of my credit cards, and to pay a collection I didn't know about. I want my credit clean with one easy payment.<br>	debt_consolidation	Debt Killer	937xx	CA	27.06	0	Mar-99	0			12	0	9996	70.90%	17	f	10365.14	10365.14	3235.28	3235.28	1134.86	2100.42	0	0	0	14-Nov	323.54	15-Jan	14-Nov	0		1
	//	0			1			2		3		4		5				6	7		8	9	10			11		12		13		
			
//initized counter 		
		
		HashMap <String , Integer> counter=new HashMap<String, Integer>();
		int CountA=0, CountB=0, CountC=0, CountD=0, CountE=0, CountF=0, CountG=0;
		
// Convert into String and split
			
			String[] line = value.toString().split(",");
			int loan=Integer.parseInt(line[2].trim());
							
						
				switch (line[8].trim().charAt(0))
				{
					case 'A':
						 CountA=CountA + loan;
						 counter.put("A", CountA);
						   break;
						   
					case 'B':
						CountB =CountB +loan;
						counter.put("B", CountB);

							break;
					case 'C':
						CountC =CountC + loan;
						counter.put("C", CountC);

							break;
					case 'D':
						CountD =CountD +loan;
						counter.put("D", CountD);
							break;
				
					case 'E':
						CountE = CountE +loan;
						counter.put("E", CountE);
						break;
						
					case 'F':
						CountF =CountF +loan;
						counter.put("F", CountF);
						break;
						
					case 'G':
						CountG = CountG +loan;
						counter.put("G", CountG);
						break;
				}

			
			counter.toString();
			Output.collect(new Text(counter.toString()), new IntWritable(1));
			
		}
	
}