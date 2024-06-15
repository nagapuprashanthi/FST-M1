# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Verify the title of the second most popular course
# Goal: Read the title of the second most popular course on the website and verify the text


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Get the title of the second most popular course
    Title = driver.find_element(By.XPATH,"//*[@id='post-71']/div[2]/h3")
    TitleOfSecondPopularCourse = Title.text

    print("Title of second most popular course is: ", TitleOfSecondPopularCourse)

    # Make sure it matches "Email Marketing Strategies" exactly
    assert TitleOfSecondPopularCourse == "Email Marketing Strategies"

    # If it matches, close the browser
    driver.quit