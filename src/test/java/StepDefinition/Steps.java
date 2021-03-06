package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

    private WebDriver driver;

    private By searchBoxLocator = By.id("search_query_top");
    private By searchBtnLocator = By.name("submit_search");
    private By resultTextLocator = By.cssSelector("span.heading-counter");


    @Given("Abre el web browser Chrome y direcciona a la aplicacion$")
    public void open_the_web_browser() throws Throwable
    {

        /*
        System.setProperty("webdriver.chrome.driver"
                , "drivers//chromedriver.exe");


         */

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");

    }

    @When("Ingreso el nombre del producto a buscar blouse$")
    public void ingreso_el_nombre_producto_a_buscar()throws Throwable
    {

        driver.findElement(searchBoxLocator).sendKeys("blouse");

        driver.findElement(searchBtnLocator).click();

    }

    @When("Ingreso el nombre del producto a buscar shoes$")
    public void ingreso_el_nombre_producto_a_buscar2()throws Throwable
    {

        driver.findElement(searchBoxLocator).sendKeys("shoes");

        driver.findElement(searchBtnLocator).click();

    }

    @Then("Visualizo resultado de la busqueda$")
    public void visualizo_resultados()throws Throwable
    {
        String resulttext = driver.findElement(resultTextLocator).getText();

        System.out.println("Resultado:" + resulttext);
    }

    @And("Cierro el Browser$")
    public void Quit() throws Throwable {

        driver.close();

    }

}
