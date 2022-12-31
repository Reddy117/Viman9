package com.orangehrm.factory;

import com.ornagehrm.pages.AdminPage;
import com.ornagehrm.pages.LeavePage;
import com.ornagehrm.pages.LoginPage;
import com.ornagehrm.pages.PIMPage;

public interface BasePageFactory {

	LoginPage getLoginPage();
	PIMPage getPimPage();
	AdminPage getAdminPage();
	LeavePage getLeavePage();
	
}
