package generic.assertions;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement>  {
private Logger logger = LogManager.getLogger(AssertWebElement.class);
    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed(){
        logger.info("Sprawdzenie czy element się wyświetla");
        isNotNull();
        if (!actual.isDisplayed()){
            failWithMessage("Element się nie wyświetla");
        }
        logger.info("WebElement się wyświetla");
        return this;
    }
    public AssertWebElement hasText(String expectedTextValue){
        logger.info("Sprawdzenie czy WebElement zawiera tekst: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if (!actualElementText.equals(expectedTextValue)) {
            failWithMessage("Element zawierający tekst <%s> spodziewany rezultat <%s>!", actualElementText, expectedTextValue);
        }
        logger.info("WebElement zawiera spodziewany tekst");
        return this;
    }
}
