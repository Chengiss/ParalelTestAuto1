AUTO1 TASK
----------
###### Cengiz Ucar Apr 12,2021



#### _TASK 1: Address Validation Scenario_
* Task 1 is attached under the Task 2 project files and named **_Auto1_Task1_Address_Validation.xlsx_**

#### _TASK 2: Search Function Automation_
* To get _html test report_ after execution, run the task through `mvn verify` command.

```gherkin
    Feature: Search Function
        #1
       Scenario: verify using "first registiration filter" together with "price sorting"
          #2
          Given the user is on the "search" page
          #3
          When registration filter is year "2015" and "ab" selected
          #4
          And sorting option is as "Höchster Preis" selected
          #5
          Then all cars' registrations should be 2015 and "newer"
          #6
          And all cars are sorted by price "descending"
```          

_#1 scenario methods are parameterized for versatility and reusability._\
_#2 only "search" page is available. future page adding is possible._\
_#3 any year(string) and "ab" or "bis" can be selected._\
_#4 other sort options also can be entered ex:"Niedrigster Preis"._\
_#5 any year(int) together with "newer" and "older" options are selectable._\
_#6 "ascending" or "descending" options are available for verifying._
