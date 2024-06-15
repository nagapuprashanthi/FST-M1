# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Verify the website heading
# Goal: Read the heading of the website and verify the text


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Get the heading of the webpage
    heading = driver.find_element(By.XPATH,"//*[@id='uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896']/div/div/div/div[1]/h1")
    headingOfWebPage = heading.text

    print("Heading of the webpage is: ", headingOfWebPage)

    # Make sure it matches "Learn from Industry Experts" exactly
    assert headingOfWebPage == "Learn from Industry Experts"

    # If it matches, close the browser
    driver.quit