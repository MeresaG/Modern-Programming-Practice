package lesson10.labs.prob1.bugreporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Logger;

import lesson10.labs.prob1.classfinder.ClassFinder;

/**
 * This class scans the package lesson10.labs.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "   reportedBy: ";
	private static final String CLASS_NAME =  "   classname: ";
	private static final String DESCRIPTION = "   description: ";
	private static final String SEVERITY =    "   severity: ";
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\lesson10\\labs\\prob1\\bugreporter\\";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		
		//sample code for reading annotations -- you will need to change
		//this quite a bit to solve the problem
		//Sample code below obtains a list of names of developers assigned to bugs
		List<String> names = new ArrayList<String>();
		//key Developer Name, Value: Other report
		HashMap<String,List<String>> dataDict =new HashMap<>();
		
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				String name = annotation.assignedTo();
				StringBuilder sb= new StringBuilder(REPORTED_BY+annotation.reportedBy()+"\n");
				sb.append(CLASS_NAME+cl.toString().substring(6)+"\n");
				sb.append(DESCRIPTION+annotation.description()+"\n");
				sb.append(SEVERITY+annotation.severity());
				/*
				names.add(name);
				System.out.println(annotation.assignedTo());
				System.out.println(cl.toString().substring(6));
				System.out.println(annotation.description());
				System.out.println(annotation.severity());
				 */
				if(dataDict.containsKey(name)) {
					List<String> bugs=dataDict.get(name);
					bugs.add(sb.toString());
					dataDict.put(name, bugs);
//					dataDict.put(name,dataDict.get(name).add(sb.toString()));
				}else {
					List<String> bugs=new ArrayList();
					bugs.add(sb.toString());
					dataDict.put(name, bugs);
				}
			}
		}
//		System.out.println(dataDict);
	//Output to Console	
		for( String name:dataDict.keySet()) {
			System.out.println(name);
			for(String bug:dataDict.get(name)) {
				System.out.println(bug+"\n");
			}
		}
		
		//Write to file
		File file =new File(OUTPUT_DIR+REPORT_NAME);
		//create new file
		if(!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("File is already there, no need to create");
				//e.printStackTrace();
			}
		}
		System.out.println("Is file created ?: "+file.isFile());
		try(PrintWriter pw= new PrintWriter(new FileWriter(file))){
			for( String name:dataDict.keySet()) {
				pw.println(name);
				//System.out.println(name);
				for(String bug:dataDict.get(name)) {
					pw.println(bug);
					pw.println();
//					System.out.println(bug+"\n");
				}
			}
			
		} catch (IOException e) {
			System.out.println("Main Exception : "+e.getMessage());
			//List<Throwable> supressed=Arrays.asList(e.getSuppressed());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
	
	
}
