package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.AbstractReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public abstract class Reporter {	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public static Properties prop;
	public static Connection con = null;
	public static Statement stmt;
	public String testCaseName, testDescription, authors,category;
	
	@Parameters({"dbURL"})
	@BeforeSuite(alwaysRun = true)
	public void startReport(String url) {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(false); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		reporter.loadXMLConfig("extent-config.xml");
		loadConfigFile();
		connectSQLServerDatabase(url);
		
	}
	
	/*
	 * @BeforeClass public void report() throws IOException { test =
	 * extent.createTest(testCaseName, testDescription); test.assignAuthor(authors);
	 * test.assignCategory(category); }
	 */
    public void loadConfigFile() {
    	try {
    		prop = new Properties();
    		FileInputStream ip = new FileInputStream(
    				System.getProperty("user.dir") + "/config.properties");
    		prop.load(ip);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public void connectSQLServerDatabase(String url) {
    	try {
    		
    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		//String url=prop.getProperty("DB_URL");
    		//String url="DbURL";
    		String username=prop.getProperty("DB_USER");
    		String password=prop.getProperty("DB_PASSWORD");  
    		con= DriverManager.getConnection(url,username,password);
    		  if (con == null) {
    			  System.err.println("**** Advantage DB NOT connected **** ");		
    		  }
    		  System.out.println("**** Advantage DB connected **** ");
    	}
    	catch (SQLException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
    }

    public abstract long takeSnap();
    
    public void reportStep(String dec, String status,boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
    }
    public ResultSet executeSqlQuery(String query) {
    		
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	  	
	}

	public void closeDbConection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("**** Database connection closed **** ");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
    
	
    
    @AfterSuite(alwaysRun = true)
    public void stopReport() {
    	extent.flush();
    	closeDbConection();
    }
}
