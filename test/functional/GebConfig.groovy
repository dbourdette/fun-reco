import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

driver = {
	
def driver = new HtmlUnitDriver()
driver.javascriptEnabled = true
driver
}

environments {
chrome {
driver = { new ChromeDriver() }
}

firefox {
driver = { new FirefoxDriver() }
}

}


