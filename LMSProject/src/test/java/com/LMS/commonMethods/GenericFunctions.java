package com.LMS.commonMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.LMS.context.ScnContext;

public class GenericFunctions {
		ScnContext scn;
		
		public GenericFunctions(ScnContext scn) {
			this.scn=scn;
		}

		public byte[] getByteScreenshot() throws IOException 
		{
		    File src = ((TakesScreenshot) scn.driver).getScreenshotAs(OutputType.FILE);
		    byte[] fileContent = FileUtils.readFileToByteArray(src);
		    return fileContent;
		}
		

}
