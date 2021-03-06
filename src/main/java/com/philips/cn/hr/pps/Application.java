package com.philips.cn.hr.pps;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kvn on 1/14/15.
 */
public class Application {

    protected final static Log logger = LogFactory.getLog(Application.class);

    public static JobExecution execute(String f1Name, String f2Name, String saveTo, boolean isCalcForMonthly) throws Exception {


        String applicationCtx = System.getProperty("application-context");

        if (applicationCtx == null) {
            logger.error("application context not provided.");
            System.exit(1);
        }

        logger.info("now executing the cacl. using context file " + applicationCtx);


        ApplicationContext ctx =
                new FileSystemXmlApplicationContext(createURL(applicationCtx).toString());


        JobParameters jobParameters = new JobParametersBuilder().
                addString("f1_data_file_name", createURL(f1Name).toString()).
                addString("f2_data_file_name", createURL(f2Name).toString()).
                addString("save_as_destination", createURL(saveTo).toString()).
                addString("is_monthly_cacl", String.valueOf(isCalcForMonthly)).
                toJobParameters();

        logger.info("now executing the calculation, using jobParameters " + jobParameters.toString());

        SimpleJobLauncher jobLauncher = (SimpleJobLauncher) ctx.getBean("jobLauncher");

        Job job = (Job) ctx.getBean("annual_incentive_calculation");

        return jobLauncher.run(job, jobParameters);
    }


    public static void main(String[] args) throws Exception {

//        String f1=createURL("/tmp/f1.TXT").toString();
//        String f2 =createURL("/tmp/f2.TXT").toString();
//        String s = createURL("/tmp").toString();

        String f1 = "/tmp/f1.TXT";
        String f2 = "/tmp/f2.TXT";
        String s = "/tmp";

        JobExecution execution = Application.execute(f1, f2, s, false);

//        System.out.println("args:" + Arrays.toString(args));
//
//        if (args.length != 4) {
//            //
//            System.err.println("Usage:invalid parameters");
//            System.exit(1);
//        }
//
//        String applicationCtx = System.getProperty("application-context");
//
//        ApplicationContext ctx =
//                new FileSystemXmlApplicationContext(createURL(applicationCtx).toString());
//
//        String f1Name = createURL(args[0]).toString();
//
//        String f2Name = createURL(args[1]).toString();
//
//        String saveAsDestination = createURL(args[2]).toString();
//
//        boolean isMonthlyCacl =
//                Boolean.valueOf(args[3]);  //execute cacl. monthly ;
//
//        System.out.println("Now going to execute the job with parameters: " + args);
//
//        JobParameters jobParameters = new JobParametersBuilder().
//                addString("f1_data_file_name", f1Name).
//                addString("f2_data_file_name", f2Name).
//                addString("save_as_destination", saveAsDestination).
//                addString("is_monthly_cacl", String.valueOf(isMonthlyCacl)).
//                toJobParameters();
//
//        SimpleJobLauncher jobLauncher = (SimpleJobLauncher) ctx.getBean("jobLauncher");
//        Job job = (Job) ctx.getBean("annual_incentive_calculation");
//
//        try {
//
//            JobExecution execution = jobLauncher.run(job, jobParameters);
//
//            System.out.println("Exit Status : " + execution.getStatus());
//
//            System.out.println("Exit Status : " + execution.getAllFailureExceptions());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("Done");

    }

    protected static URL createURL(String filename) {

        URL url = null;

        try {
//            url = new URL("file://" + System.getProperty("user.dir") +  File.separator + filename);
            url = new URL("file://" + File.separator + filename);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return url;
    }


}
