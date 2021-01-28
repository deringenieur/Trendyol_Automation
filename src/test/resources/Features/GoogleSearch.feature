@TestTag
Feature: feature to test Trendyol Website

  Scenario: Validate google search is working
    Given browser is open
    When user is on "https://trendyol.com" search page
    Then user clicks element if exist "//body/div[6]/div/div/a" for 10 seconds with index 1
    Then user waits element "Trendyol'da Satış Yap" for 10 seconds with index 1
    Then user clicks "//*[@id='account-navigation-container']/div/div[1]/div[1]/p" element
    Then user waits element "//*[@id='login-email']" for 10 seconds with index 1
    Then user enters "trendyol.test21@gmail.com" text in "//*[@id='login-email']" search box
    Then user tab to "TAB"
    Then user enters "Trndyol.Tst21" text in "//*[@id='login-password-input']" search box
    Then user tab to "ENTER"
    Then user clicks element if exist "//*[@id='Combined-Shape']" for 10 seconds with index 1
    Then user waits element "//*[@id='account-navigation-container']/div/div[1]/div[1]/p" for 10 seconds with index 1
    Then user creates variable with key:"price1" value:"//span[@class='prc-slg']"
    Then user creates variable with key:"price2" value:"//*[@id='basketAside']/div/div[1]/dl/dd[1]"
    And user enters "bilgisayar" text in "class=search-box" search box
    And user tab to "ENTER"
    And user waits element "//*[@class='p-card-img']" for 10 seconds with index 1
    And user clicks "//*[@class='p-card-img']" element
    And user waits element "//*[@id='product-detail-app']/div/div[2]/div[2]/div[2]/div[8]/div/button/div[1]" for 10 seconds with index 1
    Then user get values of variable "price1"
    And user clicks "//*[@id='product-detail-app']/div/div[2]/div[2]/div[2]/div[8]/div/button" element
    Then user clicks "//*[@id='account-navigation-container']/div/div[2]/a/p" element
    Then user waits element "Sepeti Onayla" for 10 seconds with index 1
    Then user get values of variable "price2"
    Then user compare variables with variable1:"price1" variable2:"price2"
    Then user clicks "//*[@id='partial-basket']/div/div[2]/div[2]/div[3]/button" element
    Then user clicks "//*[@id='ngdialog1']/div[2]/form/div/div[2]/div/div[1]/button[2]" element
    And user waits element "//*[@id='basketNoProductPage']/div[2]/div/div[1]/p/span" for 10 seconds with index 1

