package com.guru99.framework.keywordDriven;

public class ExecutionEngine {

	public static void main(String[] args) throws Exception {
		ReusableFuntion utils=new ReusableFuntion();
		
		String[][] data=utils.fetchDataFromExcelSheet();
		for(int i=1; i<data.length;i++) {
			String action=data[i][3];
			String locator=data[i][4];
			String locatorValue=data[i][5];
			String parameter=data[i][6];
			System.out.println(action +"\t"+locator+"\t"+locatorValue+"\t"+parameter);
			switch(action) {
				case "launchApp":
					utils.launchApplication();
					break;
				case "fillText":
					utils.fillText(locator,locatorValue,parameter);
					break;
				case "click": 
					utils.click(locator,locatorValue);
					break;
				case "selectDropDown": 
					utils.selectDropDown(locator,locatorValue,parameter);
					break;
				case "selectRadio": 
					utils.selectRadio(locator,locatorValue,parameter);
					break;
			}
		}
	}

}