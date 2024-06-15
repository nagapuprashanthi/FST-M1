# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Navigate to another page
# Goal: Navigate to the “My Account” page on the site.


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Find the navigation bar.
    # Select the menu item that says "My Account" and click it.
    navigationBar = driver.find_element(By.XPATH,"//*[@id='menu-item-1507']/a")
    navigationBarText = navigationBar.text
    navigationBar.click()
    print("Title of New webpage is:", navigationBarText)

    # Read the page title and verify that you are on the correct page
    currentPageTitle = driver.title
    print("Title of new page title is: ", currentPageTitle)
    assert navigationBarText in currentPageTitle

    # If it matches, close the browser
    driver.quit