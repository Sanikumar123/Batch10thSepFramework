package com.XYZBank.datareaders;

import java.io.IOException;


import org.testng.annotations.DataProvider;

import com.XYZBank.utility.Constants;



public class DataProviders {
	
	
	@DataProvider(name="CommonDataProvider")
	public Object[][] getDataFromExcel() throws IOException
	{
		Object[][] data = DataReader.readData(Constants.MASTER_XL_PATH, Constants.MASTER_XL_SHEETNAME);
		return data;
		
	}

}
