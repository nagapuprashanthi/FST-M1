# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Verify the title of the first info box
# Goal: Read the title of the first info box on the website and verify the text


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Get the title of the first info box
    Title = driver.find_element(By.XPATH,"//*[@id='uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810']/div/div/div/div[2]/h3")
    TitleOfFirstInfoBox = Title.text

    print("Title of first info box is: ", TitleOfFirstInfoBox)

    # Make sure it matches "Actionable Training" exactly.
    assert TitleOfFirstInfoBox == "Actionable Training"

    # If it matches, close the browser
    driver.quit