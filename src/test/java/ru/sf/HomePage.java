package ru.sf;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomePage {

    public static final WebDriver driver;
    public static final PageObjects pageObjects;
    private String url = "https://skillfactory.ru/";

    static {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String Url = "https://skillfactory.ru/";
        pageObjects = new PageObjects(driver);

    }

    @Before
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        pageObjects.goUrl(url);
    }

    @Test
    //test is ok
    public void equalsLogoUrl() {
        //pageObjects.goUrl();
        //driver.get("https://skillfactory.ru/");
        String url = "https://skillfactory.ru/";
        WebElement logotip = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[46]/a/img"));
        logotip.click();
        String a = driver.getCurrentUrl();
        Assert.assertEquals(a, url);


        //driver.close();
    }

    @Test
    //test is ok
    public void equalsKursAllUrl() {
        //@ParameterizedTest в будущем попробовать параметризированный тест с csv

        //driver.get("https://skillfactory.ru/");
        String urlAllKurs = "https://skillfactory.ru/courses";

        Actions action = new Actions(driver);
        WebElement Kurs = driver.findElement(new By.ByClassName("tn-elem__4567460551658239202599"));
        Kurs.click();
        WebElement allKurs = driver.findElement(new By.ByXPath("//*[@id=\"nav493615268\"]/div/div[3]/ul/li[1]/div/a/span"));

        action.moveToElement(allKurs).build().perform();
        allKurs.click();
        String b = driver.getCurrentUrl();
        Assert.assertEquals(b, urlAllKurs);

        //driver.quit();
    }

    @Test
    //test is ok
    public void equalsKursDataScience() {

        //driver.get("https://skillfactory.ru/");
        String urlAllKursDataScience = "https://skillfactory.ru/courses/data-science";

        Actions action = new Actions(driver);
        WebElement Kurs = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[45]"));
        action.moveToElement(Kurs).build().perform();
        WebElement KursDataSceience = driver.findElement(new By.ByXPath("//*[@id=\"nav493615268\"]/div/div[3]/ul/li[2]/div/a"));
        action.moveToElement(KursDataSceience).build().perform();
        KursDataSceience.click();
        String c = driver.getCurrentUrl();
        //System.out.println(c);
        Assert.assertEquals(c, urlAllKursDataScience);

        //driver.quit();
    }

    @Test
    //test is ok
    public void equalFreeEvents() {

        //driver.get("https://skillfactory.ru/");
        String urlAllKurs = "https://skillfactory.ru/events";

        Actions action = new Actions(driver);
        WebElement Kurs = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[45]"));
        action.moveToElement(Kurs).build().perform();
        WebElement KursDataSceience = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[41]"));

        action.moveToElement(KursDataSceience).build().perform();
        KursDataSceience.click();
        String c = driver.getCurrentUrl();
        Assert.assertEquals(c, urlAllKurs);

        //driver.quit();
    }

    @Test
    //test is ok
    public void equalTitelSite() {

        //driver.get("https://skillfactory.ru/");
        //String urlAllKurs = "https://skillfactory.ru/data-science";
        String titel = "Онлайн-школа SkillFactory — онлайн-обучение востребованным IT-профессиям";
        String d = driver.getTitle();
        Assert.assertEquals(d, titel);

       // driver.quit();
    }

    @Test
    //test is ok
    public void equalKorporStudTextToPage() {


        //driver.get("https://skillfactory.ru/");
        String textOfBody = "Развивайте бизнес вместе со Skillfactory";

        WebElement KorporStud = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[42]/a"));
        KorporStud.click();

        String BodyTextCorporPage = driver.findElement(new By.ByXPath("//*[@id=\"rec425993788\"]/div/div/div[3]/h1")).getText();

        Assert.assertEquals(textOfBody, BodyTextCorporPage);

        //driver.quit();


    }

    @Test
    //test is ok
    public void equalSotrudnTextOfPage() {

        //driver.get("https://skillfactory.ru/");
        String TextPartnershipBody = "Мы открыты для любых форматов сотрудничества — как традиционных, так и новых. Развивайте бизнес вместе с нами!";

        WebElement SotrudnGet = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[44]/a"));
        SotrudnGet.click();
        String actualTextParnership = driver.findElement(new By.ByXPath("//*[@id=\"rec368990860\"]/div/div/div[4]/div")).getText();
        System.out.println(actualTextParnership);
        Assert.assertEquals(TextPartnershipBody, actualTextParnership);

        //driver.quit();
    }

    @Test
    //test is ok
    public void equalBlogTextOfBody() {

        //driver.get("https://skillfactory.ru/");
        String rightLogotipeSiteText = "Как попасть в IT и освоить цифровые профессии";

        WebElement BlogButton = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[43]/a"));
        BlogButton.click();

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        System.out.println(driver.getCurrentUrl());
        // driver.findElement(new By.ByXPath("//*[@id=\"menu-item-2281\"]"));
        String logotipeSiteText = driver.findElement(new By.ByXPath("//*[@id=\"masthead\"]/div/div[2]/div[2]/p")).getText();

        //System.out.println(logotipeSiteText);
        Assert.assertEquals(logotipeSiteText, rightLogotipeSiteText);

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
        Assert.assertEquals(equalTelNuber1, num1);
        WebElement telNuber2 = driver.findElement(new By.ByXPath("//*[@id=\"rec456746055\"]/div/div/div[40]/div/a"));
        String num2 = telNuber2.getText();
        Assert.assertEquals(equalTelNuber2, num2);

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
        Assert.assertEquals(ExpectedMassageText, textDialogMessage);

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
        Assert.assertEquals(ExpectedMassageText, textDialogMessage);

        //driver.quit();
    }

    @Test
    //test is ok
    public void MassageEnterRightNameAndRigthEmail() {

        //driver.get("https://skillfactory.ru/");
        String textDialogMessage = "Пожалуйста, заполните все обязательные поля";


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
        String ErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]/div[1]")).getText();
        Assert.assertEquals(ErrorMessage, textDialogMessage);

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

        Assert.assertEquals(findErrorMessage, textDialogMessage);

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

        Assert.assertEquals(ErrorMessage, textDialogMessage);

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

        String textError = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[2]/div[5]/div/div/p[2]")).getText();
        Assert.assertEquals(textError, textDialog);

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
        Assert.assertEquals(textError, textDialog);

        //driver.quit();
    }

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

        String textDialogActual = driver.findElement(new By.ByXPath("//*[@id=\"form456746072\"]/div[1]")).getText();
        Assert.assertEquals(textDialogActual, textDialog);

        //driver.close();
    }

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

        String catchErrorText = driver.findElement(new By.ByXPath("//*[@id=\"tilda-popup-for-error\"]/div[1]/p")).getText();
        //System.out.println(catchErrorText);
        Assert.assertEquals(catchErrorText,textDialogMessage);

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
        Assert.assertEquals(errorMessage,catchErrorText);

        //driver.quit();

    }

    @Test
    //test is ok -  fail kapcha ((((
    public void getFreeItAllRight(){

        //driver.get("https://skillfactory.ru/");
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

    }


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
        Assert.assertEquals(urlHabr, HabrUrlActual);

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
        Assert.assertEquals(urlVk, HabrUrlActual);

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
        Assert.assertEquals(urlTwit, TwitUrlActual);

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
        Assert.assertEquals(HabrUrlActual, urlYoutube);

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
        Assert.assertEquals(urlHabr, HabrUrlActual);

        //driver.quit();

    }


    @Test
    //test is ok
    public void checkFooterSocSiteYandex() {

       // driver.get("https://skillfactory.ru/");
        String urlHabr = "https://dzen.ru/skillfactory";


        WebElement VkUrl = driver.findElement(new By.ByXPath("//*[@id=\"rec298827602\"]/div/div/div[15]/div/a"));
        VkUrl.click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        String HabrUrlActual = driver.getCurrentUrl();
        Assert.assertEquals(urlHabr, HabrUrlActual);

        //driver.quit();

    }

   /* @AfterClass
            public static void end()
    {
        driver.quit();
        System.out.println("test finish");
    }*/
}



