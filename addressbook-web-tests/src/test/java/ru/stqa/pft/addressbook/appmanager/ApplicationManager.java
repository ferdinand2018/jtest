package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String broweser;

    public ApplicationManager(String broweser) {
        this.broweser = broweser;
    }

    public void init() {
        if(broweser.equals(BrowserType.FIREFOX)){
            //wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:\\Users\\mkonovalov\\old\\firefox.exe"));

        } else if(broweser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(broweser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }
        //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public ContactHelper getContacHelper() {return contactHelper; }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}