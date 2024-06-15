# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Logging into the site
# Goal: Open the website and log-in using the provided credentials


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

    # Verify that you have logged in
    Verification = driver.find_element(By.LINK_TEXT,"Edit profile").text
    print("Verification text is: ", Verification)
    assert "Edit profile" == Verification

    # If it matches, close the browser
    driver.quit