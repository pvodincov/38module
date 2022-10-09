package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import ru.HomePageMetods;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class oneTest {

    private static WebDriver driver;
    private static HomePageMetods homePageMetods;
    private String url = "https://skillfactory.ru/";

   static  {
       System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String Url = "https://skillfactory.ru/";
        homePageMetods = new HomePageMetods(driver);

    }

    @BeforeEach
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        homePageMetods.goUrl(url);
    }
    @Test
    //test is ok
    public void equalsLogUrl() {

        String url = "https://skillfactory.ru/";

        homePageMetods.clickLogotipe();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);

    }

    @Test
    //@ParameterizedTest
    //@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    //test is ok
    public void equalsKursAllUrl() {
        String urlAllKurs = "https://skillfactory.ru/courses";

        homePageMetods.urlAllKurs();
        String currentUrl = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(currentUrl, urlAllKurs);

    }
    @Tag("test HEAD Menu")
    @Test
//@ParameterizedTest
//@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
//test is ok

    //test is ok
    public void equalFreeEvents() {
        String urlAllKurs = "https://skillfactory.ru/events";

        homePageMetods.KursFreeEvents();
        String currentUrl = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(currentUrl, urlAllKurs);
    }

    @Test
    //test is ok
    public void equalTitelSite() {

        //driver.get("https://skillfactory.ru/");
        //String urlAllKurs = "https://skillfactory.ru/data-science";
        String titel = "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям";
        String d = driver.getTitle();
        org.junit.Assert.assertEquals(d, titel);

        // driver.quit();
    }

    @Test
    //test is ok
    public void equalKorporStudUrl() {

        String expectedUrl = "https://new.skillfactory.ru/corporativnoye-obuchenye";

        homePageMetods.KorporStud();
        String a = driver.getCurrentUrl();
        Boolean b = (a.contains(expectedUrl));
        assertTrue(b);
    }

    @Test
    //test is ok
    public void equalSotrudnUrl() {

        String ExpectedUrl = "https://new.skillfactory.ru/partnership";

        homePageMetods.equalSotrudnUrl();
        String a = driver.getCurrentUrl();
        //System.out.println(a);
        Boolean b = (a.contains(ExpectedUrl));
        assertTrue(b);
        //driver.quit();
    }

    @Test
    //test is ok
    public void equalBlogTextOfBody() {

        String equalUrl = "https://blog.skillfactory.ru/";

        homePageMetods.equalBlogUrl();

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        String a = driver.getCurrentUrl();
        System.out.println(a);
        Boolean b = (a.contains(equalUrl));
        assertTrue(b);

        // driver.quit();

    }

    @Test
    //test is ok
    public void checkTelNumber() {

        //driver.get("https://skillfactory.ru/");
        String equalTelNuber1 = "+7 495 291-09-12";
        String equalTelNuber2 = "+7 958 577-04-17";

        WebElement telNumber1 = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[39]/div/a"));
        String num1 = telNumber1.getText();
        org.junit.Assert.assertEquals(equalTelNuber1, num1);
        WebElement telNuber2 = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[40]/div/a"));
        String num2 = telNuber2.getText();
        org.junit.Assert.assertEquals(equalTelNuber2, num2);

        //driver.quit();

    }

    @Test
    //test is ok
    public void checkMassageEnterNullData() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Обязательное поле";
        WebElement buttonSupport = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]/button"));
        buttonSupport.click();
        buttonSupport.click();
        buttonSupport.click();

        String ExpectedMassageText = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/div")).getText();

        System.out.println(ExpectedMassageText);
        org.junit.Assert.assertEquals(ExpectedMassageText, textDialogMessage);

        //driver.quit();


    }

    @Test
    //test is ok
    public void MassageEnterRightName() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Пожалуйста, заполните все обязательные поля";

        WebElement enterName = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/input"));
        enterName.click();
        enterName.sendKeys("test");
        WebElement ButtonGetKonsul = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]/button"));
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();

        String ExpectedMassageText = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]")).getText();
        // System.out.println(ExpectedMassageText);
        org.junit.Assert.assertEquals(ExpectedMassageText, textDialogMessage);

        //driver.quit();
    }

    @Test
    //test is ok
    public void MassageEnterRightNameAndRigthEmail() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Обязательное поле";


        WebElement enterName = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/input"));
        enterName.click();
        enterName.sendKeys("test");

        WebElement enterEmail = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[2]/div/input"));
        enterEmail.click();
        enterEmail.sendKeys("test@mail.ru");
        WebElement ButtonGetKonsul = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]/button"));
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();
        String ErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[3]/div/div[2]")).getText();
        System.out.println(ErrorMessage);
        org.junit.Assert.assertEquals(ErrorMessage, textDialogMessage);

        // driver.quit();


    }

    @Test
    //test is ok
    public void MassageEnterRightNameAndFailEmail() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Укажите, пожалуйста, корректный email";

        WebElement enterName = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/input"));
        enterName.click();
        enterName.sendKeys("test");

        WebElement enterEmail = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[2]/div/input"));
        enterEmail.click();
        enterEmail.sendKeys("test@mail.");

        WebElement ButtonGetKonsul = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]/button"));
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();

        String findErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[2]/div/div")).getText();

        org.junit.Assert.assertEquals(findErrorMessage, textDialogMessage);

        // driver.quit();

    }

    @Test
    //test is ok
    public void MessageEnterRightNameAndRightEmailAndShortNumber() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Слишком короткое значение";


        WebElement enterName = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/input"));
        enterName.click();
        enterName.sendKeys("test");

        WebElement enterEmail = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[2]/div/input"));
        enterEmail.click();
        enterEmail.sendKeys("test@mail.ru");

        WebElement ButtonGetKonsul = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]/button"));

        WebElement enterNumber = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[3]/div/div[1]/input[1]"));
        enterNumber.click();
        enterNumber.sendKeys("123");

        ButtonGetKonsul.click();
        ButtonGetKonsul.click();
        ButtonGetKonsul.click();

        String ErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]/div[1]")).getText();

        org.junit.Assert.assertEquals(ErrorMessage, textDialogMessage);

        // driver.quit();
    }


    /*@Test
    //test in  ok - captcha failed test
    public void MessageEnterRightNameAndRightEmailAndRightNumber(){

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Укажите, пожалуйста, корректный номер телефона";

        WebElement enterName = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[1]/div/input"));
        enterName.click();
        enterName.sendKeys("test");

        WebElement enterEmail = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[2]/div/input"));
        enterEmail.click();
        enterEmail.sendKeys("test@mail.ru");


        WebElement enterNumber = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[3]/div/div[1]/input[1]"));
        enterNumber.click();
        enterNumber.sendKeys("(123) 412-51-23");


        WebElement ButtonGetConsul = driver.findElement(new By.ByXPath("//*[@id=\"form456746058\"]/div[2]/div[5]"));

        ButtonGetConsul.click();

        WebElement Kapcha = driver.findElement(new By.ByXPath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
        Kapcha.click();


        String ErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"tildaformsuccesspopup\"]/div/div")).getText();

        System.out.println(ErrorMessage);
        Assert.assertEquals(ErrorMessage, textDialogMessage);
        driver.quit();

        //*[@id="tildaformsuccesspopup"]/div/div
    }*/

    @Test
    //test is ok
    public void getKonsulNullData() {

        // driver.get("https://skillfactory.ru/");
        String textDialog = "Пожалуйста, заполните все обязательные поля";

        WebElement buttonGetConsul = driver.findElement(new By.ByXPath("//*[@id=\"rec456746070\"]/div/div/div[6]/a"));
        buttonGetConsul.click();
        WebElement buttonSubmit = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[6]/button"));
        buttonSubmit.click();
        buttonSubmit.click();
        buttonSubmit.click();

        String textError = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[5]/div/div/p[2]")).getText();
        org.junit.Assert.assertEquals(textError, textDialog);

        // driver.quit();
    }

    @Test
    //test is ok
    public void getKonsulNameNullEmailFailShortNumber() {

        //driver.get("https://skillfactory.ru/");
        String textDialog = "Пожалуйста, заполните все обязательные поля\n" +
                "Укажите, пожалуйста, корректный email\n" +
                "Слишком короткое значение";

        WebElement buttonGetConsul = driver.findElement(new By.ByXPath("//*[@id=\"rec456746070\"]/div/div/div[6]/a"));
        buttonGetConsul.click();

        WebElement EmailPlace = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[2]/div/input"));
        EmailPlace.click();
        EmailPlace.sendKeys("asdf");

        WebElement NumberPlace = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[3]/div/div[1]/input[1]"));
        NumberPlace.click();
        NumberPlace.sendKeys("123");

        WebElement checkIndicator = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[4]/div/label/div"));
        checkIndicator.click();


        WebElement buttonSubmit = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[6]/button"));
        buttonSubmit.click();

        String textError = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[5]/div/div")).getText();
        org.junit.Assert.assertEquals(textError, textDialog);

        //driver.quit();
    }

/*
    @Test
    //test is ok. id kapcha visible - test fail
    public void getKonsulNameRightEmailRightNumberRight(){

        //driver.get("https://skillfactory.ru/");
        String textDialog = "Спасибо! Мы позвоним вам в течение дня с 10 до 19 и поможем выбрать направление для обучения";

        WebElement buttonGetConsul = driver.findElement(new By.ByXPath("//*[@id=\"rec456746070\"]/div/div/div[6]/a"));
        buttonGetConsul.click();

        WebElement namePlace = driver.findElement (new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[1]/div/input"));
        namePlace.click();
        namePlace.sendKeys("test");

        WebElement EmailPlace = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[2]/div/input"));
        EmailPlace.click();
        EmailPlace.sendKeys("test@mail.ru");

        WebElement NumberPlace = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[3]/div/div[1]/input[1]"));
        NumberPlace.click();
        NumberPlace.sendKeys("345 123 45 45");


        WebElement buttonSubmit = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[6]/button"));
        buttonSubmit.click();
        buttonSubmit.click();
        buttonSubmit.click();

        String textDialogActual = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[1]")).getText();
        Assert.assertEquals(textDialogActual, textDialog);

        //driver.close();
    }
*/

    @Test
    //test is ok
    public void getFreeItFailNotCheckPunkt(){

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Пожалуйста, заполните все обязательные поля";

        WebElement checkIndicator = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[2]/div/label/div[1]"));
        checkIndicator.click();

        WebElement GetFreeIt = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[4]/button"));
        GetFreeIt.click();
        GetFreeIt.click();
        GetFreeIt.click();

        String catchErrorText = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]")).getText();
        System.out.println(catchErrorText);
        org.junit.Assert.assertEquals(catchErrorText,textDialogMessage);

        //driver.quit();

    }

    @Test
    //test is ok
    public void getFreeItFailEmail(){

        //driver.get("https://skillfactory.ru/");
        String errorMessage = "Укажите, пожалуйста, корректный email";

        WebElement EmailPole = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[1]/div/input"));
        EmailPole.click();
        EmailPole.sendKeys("asdf");

        WebElement SubmitButton = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[4]/button"));
        SubmitButton.click();
        SubmitButton.click();
        SubmitButton.click();

        String catchErrorText = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]")).getText();
        //System.out.println(catchErrorText);
        org.junit.Assert.assertEquals(errorMessage,catchErrorText);

        //driver.quit();

    }

   /* @Test
    //test is ok -  fail kapcha ((((
    public void getFreeItAllRight(){

        //driver.get("https://skillfactory.ru/");
        String kapchaText = "Please check the box to let us know you're human";
        String errorMessage = "Спасибо! Данные успешно отправлены.";

        WebElement EmailPole = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[1]/div/input"));
        EmailPole.click();
        EmailPole.sendKeys("test@mail.ru");

        WebElement SubmitButton = driver.findElement(new By.ByXPath("//*[@id=\"form456746079\"]/div[2]/div[4]/button"));
        SubmitButton.click();
        SubmitButton.click();
        SubmitButton.click();

        String catchErrorText = driver.findElement(new By.ByXPath("//*[@id=\"tildaformsuccesspopup\"]/div/div")).getText();
        //System.out.println(catchErrorText);

        Assert.assertEquals(errorMessage,catchErrorText);

        //driver.quit();

    }*/


    @Test
    //test is ok
    public void checkFooterSocSiteHabr() {
        //pageObjects.goUrl();
        // driver.get("https://skillfactory.ru/");
        String urlHabr = "https://habr.com/ru/company/skillfactory/blog/";


        WebElement HabrUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[27]/div/a"));
        HabrUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String HabrUrlActual = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(urlHabr, HabrUrlActual);

        //driver.quit();

    }

    @Test
    //test is ok
    public void checkFooterSocSiteVk() {

        // driver.get("https://skillfactory.ru/");
        String urlVk = "https://vk.com/skillfactoryschool";

        WebElement VkUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[14]/div/a"));
        VkUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String HabrUrlActual = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(urlVk, HabrUrlActual);

        //driver.quit();

    }

    @Test
    //test is ok
    public void checkFooterSocSiteTwitter() {

        //driver.get("https://skillfactory.ru/");
        String urlTwit = "https://twitter.com/skillfactoryru";


        WebElement VkUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[11]/div/a"));
        VkUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String TwitUrlActual = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(urlTwit, TwitUrlActual);

        //driver.quit();

    }

    @Test
    //test is ok
    public void checkFooterSocSiteYoutube() {

        // driver.get("https://skillfactory.ru/");
        String urlYoutube = "https://www.youtube.com/channel/UClOTq6XN8g7-16QLGnZ6_EA";

        WebElement VkUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[12]/div/a"));
        VkUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String HabrUrlActual = driver.getCurrentUrl();

        org.junit.Assert.assertEquals(HabrUrlActual, urlYoutube);

        //driver.quit();

    }


    @Test
    //test is ok
    public void checkFooterSocSiteTelegram() {

        //driver.get("https://skillfactory.ru/");
        String urlHabr = "https://t.me/skillfactory";


        WebElement VkUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[13]/div/a"));
        VkUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String HabrUrlActual = driver.getCurrentUrl();
        org.junit.Assert.assertEquals(urlHabr, HabrUrlActual);

        //driver.quit();

    }


    @Test
    //test is ok
    public void checkFooterSocSiteYandex() {

        // driver.get("https://skillfactory.ru/");
        String TextTitel = "Skillfactory";


        homePageMetods.checkFooterYandex();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String a = driver.findElement(new By.ByXPath("/html/body/div[2]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/div[1]/span")).getText();
        //System.out.println(a);
        org.junit.Assert.assertEquals(a,TextTitel);
        /*String a = driver.getCurrentUrl();
        System.out.println(a);
        Boolean b = (a.contains(urlYa));
        assertTrue(b);*/

        //driver.quit();

    }

   /* @AfterClass
            public static void end()
    {
        driver.quit();
        System.out.println("test finish");
    }*/

    /* @AfterTest(alwaysRun = true)
     public void closeWindow(){
         driver.close();
     }*/
    @AfterClass
    public void closeBrowser(){

        driver.quit();
    }
}





