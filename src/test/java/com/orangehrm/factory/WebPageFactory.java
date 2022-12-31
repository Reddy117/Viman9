package com.orangehrm.factory;

import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Page;
import com.ornagehrm.pages.AdminPage;
import com.ornagehrm.pages.LeavePage;
import com.ornagehrm.pages.LoginPage;
import com.ornagehrm.pages.PIMPage;

public class WebPageFactory implements BasePageFactory {

	public LoginPage getLoginPage() {
		return PageFactory.initElements(new Page().driver, LoginPage.class);
	}

	public PIMPage getPimPage() {
		return PageFactory.initElements(new Page().driver, PIMPage.class);
	}

	public AdminPage getAdminPage() {
		return PageFactory.initElements(new Page().driver, AdminPage.class);
	}

	@Override
	public LeavePage getLeavePage() {
		return PageFactory.initElements(new Page().driver, LeavePage.class);

	}

}
