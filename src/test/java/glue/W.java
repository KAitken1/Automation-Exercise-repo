package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class W {
    private static final Logger logger = LoggerFactory.getLogger(W.class);
    private static W instance = null;

    public static W get() {
        if (instance == null) {
            instance = new W();
        }
        return instance;
    }

    protected WebDriver driver;

    //Private constructor to initialise WebDriver and manage ChromeDriver
    private W() {
        try {
            logger.info("Setting up ChromeDriver using WebDriverManager.");
            WebDriverManager.chromedriver().setup(); // Setup ChromeDriver using WebDriverManager

            driver = new ChromeDriver(); //Initialise ChromeDriver instance
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Set implicit wait timeout
            driver.manage().window().maximize(); //Maximise the browser window
            logger.info("ChromeDriver initialized successfully.");
        } catch (Exception e) {
            logger.error("Error occurred during ChromeDriver setup.", e);
            throw e;
        }
    }

    //Method to close the WebDriver instance
    public static void close() {
        if (instance != null) {
            try {
                logger.info("Closing ChromeDriver.");
                instance.driver.close(); //Close the WebDriver instance
                instance = null; //Reset the singleton instance
                logger.info("ChromeDriver closed successfully.");
            } catch (Exception e) {
                logger.error("Error occurred while closing ChromeDriver.", e);
                throw e;
            }
        }
    }
}
