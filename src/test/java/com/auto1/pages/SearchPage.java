package com.auto1.pages;

import com.auto1.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    public SearchPage() { PageFactory.initElements(Driver.get(), this);}

    @FindBy(id="yearFilter")
    public WebElement yearFilterButton;

    //@FindBy(css = "div.root___1yEZq div.root___1GlEV.rootBottomEnd___1HS_K select#rangeStart")

    @FindBy(css = ".container___2SMPk.menuContainer___22AAQ.containerBottomEnd___1NYoL select#rangeStart")
    public WebElement registrationRangeStart;

    @FindBy(css = ".container___2SMPk.menuContainer___22AAQ.containerBottomEnd___1NYoL select#rangeEnd")
    public WebElement registrationRangeEnd;

    @FindBy(id = "sortBy")
    public WebElement sortButton;

    @FindBy(css = "h1.title___1YEGU")
    public WebElement searchPageTitle;

    @FindBy(xpath = "//ul[@class='specList___2i0rY']/li[1]")
    public List<WebElement> registrationYearTags;

    @FindBy(css = "button.button___50Uee")
    public WebElement filterTag;

    @FindBy(css = "div.price___1A8DG")
    public List<WebElement> priceTags;

}
