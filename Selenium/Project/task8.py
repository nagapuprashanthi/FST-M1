# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Contact the admin
# Goal: Navigate to the “Contact Us” page and complete the form

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to ‘https://alchemy.hguy.co/lms’.
    driver.get("https://alchemy.hguy.co/lms/")

    # Find the navigation bar.
    # Select the menu item that says "Contact" and click it.
    menuItem = driver.find_element(By.LINK_TEXT,"Contact")
    menuItemText = menuItem.text
    menuItem.click()
    print("Title of New webpage is:", menuItemText)

    # Find the contact form fields (Full Name, email, etc.)
    # Fill in the information and leave a message.
    # Click submit.
    driver.find_element(By.XPATH,"//input[@id='wpforms-8-field_0']").send_keys("Praha")
    driver.find_element(By.XPATH,"//input[@type='email']").send_keys("Praha@example.com")
    driver.find_element(By.CSS_SELECTOR,"input[id='wpforms-8-field_3']").send_keys("Test")
    driver.find_element(By.XPATH,"//textarea[@id='wpforms-8-field_2']").send_keys("Need new courses")
    driver.find_element(By.XPATH,"//button[@type='submit']").click()

    # Read and print the message displayed after submission
    displayedMessage = driver.find_element(By.XPATH,"//*[@id='wpforms-confirmation-8']/p")
    print("Displayed message after submission is: ", displayedMessage.text)
    assert "Thanks" in displayedMessage.text

    # close the browser
    driver.quit
