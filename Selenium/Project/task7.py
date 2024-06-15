# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Count the number of courses
# Goal: Navigate to the “All Courses” page and count the number of courses.


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Find the navigation bar.
    # Select the menu item that says "All Courses" and click it.
    menuItem = driver.find_element(By.LINK_TEXT,"All Courses")
    menuItemText = menuItem.text
    menuItem.click()
    print("Title of New webpage is:", menuItemText)

    # Find all the courses on the page
    # Print the number of courses on the page
    courses = driver.find_elements(By.CLASS_NAME,"entry-title")
    numberOfCourses = len(courses)
    print("number of courses are: ", numberOfCourses)
    
    # close the browser
    driver.quit