package glue;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSteps {
    private static final Logger logger = LoggerFactory.getLogger(GoogleSteps.class);

    // Step to launch a given URL
    @Given("url {string} is launched")
    public void urlIsLaunched(String url) {
        try {
            W.get().driver.get(url); //Open the URL (google)
            acceptCookiesIfWarned(); //Handle cookie banner if appears
            logger.info("URL launched: {}", url);
        } catch (Exception e) {
            logger.error("Failed to launch URL: {}", url, e);
            throw e;
        }
    }

    //Helper method to accept cookies if a cookie banner is present
    private static void acceptCookiesIfWarned() {
        try {
            WebDriverWait wait = new WebDriverWait(W.get().driver, Duration.ofSeconds(10));
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#L2AGLb")));
            cookieBanner.click(); // Click on the cookie banner
            logger.info("Accepted cookies");
        } catch (Exception e) {
            logger.warn("Cookie banner not found or couldn't be clicked", e);
        }
    }

    //Step to navigate to the About page
    @When("About page is shown")
    public void aboutPageIsShown1() {
        WebDriver driver = W.get().driver;
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        aboutLink.click(); // Click the About link
        logger.info("Navigated to the About page");
    }

    //Step to verify the page displays specific text
    @Then("page displays {string}")
    public void pageDisplays(String expectedText) {
        WebDriver driver = W.get().driver;
        WebElement bodyElement = driver.findElement(By.tagName("body"));
        String bodyText = bodyElement.getText(); //Get the text of the page body
        assertTrue("The expected text is not found on the page!", bodyText.contains(expectedText));
        logger.info("Verified the page displays the expected text: {}", expectedText);
    }

    //Step to perform a search with a given the query
    @When("searching for {string}")
    public void searchingFor(String searchQuery) {
        WebElement searchBox = W.get().driver.findElement(By.name("q"));
        searchBox.sendKeys(searchQuery); // Type the search query
        searchBox.submit(); // Submit the search form
        logger.info("Searched for: {}", searchQuery);
    }

    //Step to verify search results that contains a specific link
    @Then("results contain {string}")
    public void resultsContain(String expectedLink) {
        WebElement searchResult = W.get().driver.findElement(By.xpath("//h3[contains(text(),'" + expectedLink + "')]"));
        assertTrue("Expected link is not found in the results!", searchResult.isDisplayed());
        logger.info("Results contain the expected link: {}", expectedLink);
    }
    
    //
    @Given("the user is on the Google search page")
    public void userIsOnGoogleSearchPage() {
        // Assuming the user is already on the Google search page as per the background step
        logger.info("User is on the Google search page");
    }
    
    //Step to search for string via im feeling lucky
    @When("the user searches for {string} using I'm Feeling Lucky")
    public void searchUsingImFeelingLucky(String searchTerm) {
        WebElement searchBox = W.get().driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        
        // Click the "I'm Feeling Lucky" button
        WebElement luckyButton = W.get().driver.findElement(By.name("btnI"));
        luckyButton.click();
        
        logger.info("Performed 'I'm Feeling Lucky' search for '{}'", searchTerm);
    }   

    //Step to direct user to the top page result
    @Then("the user should be directly taken to the top result page")
    public void verifyDirectToTopResultPage() {
        String currentUrl = W.get().driver.getCurrentUrl();
        assertTrue("Unexpected URL format after using 'I'm Feeling Lucky'.", currentUrl.startsWith("https://en.wikipedia.org/wiki/Cat"));
        logger.info("Successfully redirected to the top result page after using I'm Feeling Lucky");
    }
}
