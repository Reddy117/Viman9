package com.orangehrm.utils;

public class FrameUtils extends BaseClass {

	public void switchToFrame(String property) {
		driver.switchTo().frame(property);
		
	}
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public static void swithToNestedFrame(int fIndex,int seindex) {
		driver.switchTo().frame(fIndex).switchTo().frame(seindex);
	}
}
