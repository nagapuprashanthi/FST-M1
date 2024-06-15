# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Complete a simple lesson
# Goal: Navigate to a particular lesson and complete it.


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

    # Find the “Login” button on the page and click it
    driver.find_element(By.CLASS_NAME,"ld-login-button").click()

    # Find the username field of the login form and enter the username into that field.
    # Find the password field of the login form and enter the password into that field.
    # Find the login button and click it.
    driver.find_element(By.CSS_SELECTOR,"input[id='user_login']").send_keys("root")
    driver.find_element(By.CSS_SELECTOR,"input[id='user_pass']").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//input[@type='submit']").click()

    # Select the menu item that says “All Courses” and click it
    driver.find_element(By.LINK_TEXT,"All Courses").click()
    
    # Select any course and open it
    driver.find_element(By.XPATH,"//*[@class='ld-course-list-items row']/div[1]").click()
    

    # Click on a lesson in the course. Verify the title of the course
    lessonInCourse = driver.find_element(By.XPATH,"//*[@id='ld-expand-83']/div[1]/a/div[2]")
    lessonInCourseText = lessonInCourse.text.split(' ')[0].strip()
    print("lesson in the course text: ", lessonInCourseText)
    lessonInCourse.click()    
    print("New page title is:", driver.title)
    assert lessonInCourseText in driver.title

    # If it matches, close the browser
    driver.quit