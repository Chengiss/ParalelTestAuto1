package com.auto1.step_definitions;

import com.auto1.pages.SearchPage;
import com.auto1.utilities.ConfigurationReader;
import com.auto1.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auto1TaskStepDef {

    SearchPage searchPage=new SearchPage();

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String page) {
        switch (page) {
            case "search":
                Driver.get().get(ConfigurationReader.get("searchPageUrl"));
                Assert.assertEquals("Deine Autosuche: Finde deinen neuen Gebrauchtwagen",searchPage.searchPageTitle.getText());
                break;
            case "other modules":
                // to be added...
                break;
        }
    }

    @When("registration filter is year {string} and {string} selected")
    public void registration_filter_is_year_and_selected(String year, String abOrBis) throws InterruptedException, Exception {
        searchPage.yearFilterButton.click();
        Thread.sleep(2000);
        if(abOrBis.equalsIgnoreCase("ab")) {
            Select dropdownAb = new Select(searchPage.registrationRangeStart);
            dropdownAb.selectByVisibleText(year);
        }else if(abOrBis.equalsIgnoreCase("bis")){
            Select dropdownBis = new Select(searchPage.registrationRangeEnd);
            dropdownBis.selectByVisibleText(year);
        }
        else
            throw new Exception("select one of the options: ab or bis");
    }

    @When("sorting option is as {string} selected")
    public void sorting_option_is_as_selected(String selectedOption) throws InterruptedException, Exception {
        Select dropdownSort=new Select(searchPage.sortButton);
        List<WebElement> sortOptions = dropdownSort.getOptions();

        //verify given parameter is actually one of the sorting options
        boolean selectOptionFlag=true;
        for (WebElement sortOption : sortOptions) {
            if(selectedOption.equals(sortOption.getText()))
                selectOptionFlag=false;
        }
        if(selectOptionFlag) {
            throw new Exception("Choose an existing sorting option");
        }
        //after verification now we select given option
        dropdownSort.selectByVisibleText(selectedOption);
        //verify it is selected
        Assert.assertEquals(selectedOption,dropdownSort.getFirstSelectedOption().getText());
    }

    @Then("all cars' registrations should be {int} and {string}")
    public void all_cars_registrations_should_be_and(Integer expectedYear, String newerOrOlder) throws InterruptedException{
        int actualRegistrationYear=0;
        for (WebElement registrationYear : searchPage.registrationYearTags) {
            try {
               actualRegistrationYear=Integer.parseInt(registrationYear.getText());
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            if(newerOrOlder.equalsIgnoreCase("newer")){
            Assert.assertTrue(actualRegistrationYear>=expectedYear);
            }
            else if(newerOrOlder.equalsIgnoreCase("older")){
            Assert.assertTrue(actualRegistrationYear<=expectedYear);
            }
        }
    }

    @Then("all cars are sorted by price {string}")
    public void all_cars_are_sorted_by_price(String ascendOrDescend) throws Exception {
        String strTag;
        double price=0;
        List<Double> pricesList=new ArrayList<>();
        List<Double> sortedList=new ArrayList<>();
        for (WebElement priceTag : searchPage.priceTags) {
            strTag=priceTag.getText().replace("€","").replace(".","").trim();
           try{
               price=Double.parseDouble(strTag);
           }catch (NumberFormatException e){
               e.printStackTrace();
           }
            pricesList.add(price);
        }
        if(ascendOrDescend.equalsIgnoreCase("descending")) {
            sortedList.addAll(pricesList);
            Collections.sort(sortedList, Collections.reverseOrder());
            Assert.assertEquals(pricesList, sortedList);
        }
        else if(ascendOrDescend.equalsIgnoreCase("ascending")){
            sortedList.addAll(pricesList);
            Collections.sort(sortedList);
            Assert.assertEquals(pricesList, sortedList);
        }
        else
            throw new Exception("Choose an existing sorting option");
    }

}
