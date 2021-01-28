package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null;
    HashMap<String,String> variables = new HashMap<>();
    HashMap<String,String> values = new HashMap<>();
    //itemsMap.put("item1", "this is first item");


    @Given("browser is open")
    public void browser_is_open() {
       System.out.println("Insite Step - browser is open");
       System.setProperty("webdriver.chrome.driver","C:/Users/Furkan/IdeaProjects/Trendyol_Automation/src/test/resources/drivers/chromedriver.exe");

               driver = new ChromeDriver();

               driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
               driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

               driver.manage().window().maximize();
    }

    @And("user is on {string} search page")
    public void user_is_on_google_search_page(String url ) {
        System.out.println("Insite Step - user is on google search page");

        driver.navigate().to(url);
    }

    @When("user enters {string} text in {string} search box")
    public void user_enters_a_text_in_search_box(String text,String inputbox) {
        locator(inputbox,1).sendKeys(text);
    }

    @When("user get values of variable {string}")
    public void user_getvaluesofvariable(String variable) {
        String value1=locator(variables.get(variable).toString(),1).getText();
        System.out.println(value1);
        values.put(variable,value1);
    }

    @When("user creates variable with key:{string} value:{string}")
    public void user_createsVariable(String key,String value) {
        variables.put(key,value);
    }
    @When("user compare variables with variable1:{string} variable2:{string}")
    public void user_comparetwoVariablesvalue(String variable1,String variable2) {
       String value1=locator(values.get(variable1),1).getAttribute("value");
       String value2=locator(values.get(variable2),1).getAttribute("value");
       if(value1!=value2){
           Assert.fail();
       }
    }

    @When("user clicks {string} element")
    public void click_element(String element) {
        locator(element,1).click();
    }
    

    @Then("user clicks element if exist {string} for {int} seconds with index {int}")
    public void click_element_if_exist(String element, int seconds, int index) throws InterruptedException {
        WebElement myelem=null;
        for(int i=0;i<seconds;i++) {
            try
            {
                myelem= locator(element,index);
                Thread.sleep(1000);
                if(myelem!=null){
                    myelem.click();
                    break;
                }
            }
            catch(Exception e){

            }


        }
    }

    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {
        System.out.println("Insite Step - user is navigated to search results");
    }
    @Then("user tab to {string}")
    public void clickKeyboard(String key)
    {
        Actions action = new Actions(driver);
        switch (key)
        {
            case "ENTER":
                action.sendKeys(Keys.ENTER).build().perform();
                System.out.println(key+ "'a tıklandı.");
                break;
            case "TAB":
                action.sendKeys(Keys.TAB).build().perform();
                System.out.println(key+ "'a tıklandı.");
                break;
            case "PAGE_DOWN":
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
                System.out.println(key+ "'a tıklandı.");
                break;
            case "PAGE_UP":
                action.sendKeys(Keys.PAGE_UP).build().perform();
                System.out.println(key+ "'a tıklandı.");
                break;
            default:
                System.out.println("");
        }

    }
    @Then("user waits element {string} for {int} seconds with index {int}")
    public void WaitElement(String element, int seconds, int index) throws InterruptedException {
        WebElement myelem=null;

        for(int i=0;i<seconds;i++) {
            try
            {
                myelem= locator(element,index);
            }
            catch(Exception e){

            }
            Thread.sleep(1000);
            if(myelem!=null){
                break;
            }
        }
    }

    public WebElement locator(String element, int index) {
        WebElement myelem=null;

        if(element.startsWith("//")|element.startsWith("(//")){
            myelem=driver.findElements(new By.ByXPath(element)).get(index-1);
        }
        else if(element.startsWith("#")||element.startsWith(".")){
            myelem=driver.findElements(new By.ByCssSelector(element)).get(index-1);
        }
        else if(element.contains("=")){
            if(index==0){
                index=1;
            }
            String []array=element.split("=");
            myelem=driver.findElement(new By.ByXPath("(//*[@"+array[0]+"='"+array[1]+"'])["+index+"]"));
        }
        else{
            myelem=driver.findElement(new By.ByXPath("//*[text()='"+element+"' or contains(text(),'"+element+"')]" ));
        }
        return myelem;
    }
}
