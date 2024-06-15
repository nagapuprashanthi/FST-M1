# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Verify the website title
# Goal: Read the title of the website and verify the text

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Get and print the title of the page
    print("Page title is: ", driver.title)

    # Make sure it matches "Alchemy LMS – An LMS Application" exactly
    assert driver.title == "Alchemy LMS – An LMS Application"

    # If it matches, close the browser
    driver.quit