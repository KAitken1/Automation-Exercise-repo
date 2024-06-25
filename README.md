# Automation Exercise

The "Automation Exercise" project includes Java based exercises covering tasks like managing accounts, interacting with Google, and automated testing using Cucumber and Selenium. It uses Maven for handling dependencies and building the project.

# Exercies

### Exercise 1: How Many Words
### Exercise 2: Account 
### Exercise 3: Google
### Exercise 4: Password Change

# Features

- Automated Testing: Using tools such as Selenium WebDriver and Cucumber to perform automate web applications 

- Logging and Reporting: Keep track of test activities with detailed logging using SLF4J and Logback.

- Behavior-Driven Development (BDD): Supports BDD approach with Cucumber, allowing test scenarios to be written in Gherkin syntax for better collaboration between technical and non-technical stakeholders.

- Cookie Handling: Automatically handle cookie consent pop-ups during tests.

- ChromeDriver: Utilises WebDriverManager to manage ChromeDriver versions, reducing regular updates.

- SLF4J and Logback: Provides and manages logging functionalities within the project.

# Installation

Clone the repository: ```git clone https://github.com/KAitken1/Automation-Exercise-repo.git```

Navigate into the project directory: ```cd Automation-Exercise-repo```

Install dependencies using Maven: ```mvn clean install```

# Usage

To run the tests, you have two options:

1 Using Maven:

- Open a terminal and navigate to the project directory.
- Run: ```mvn test```

2 Using an IDE:

- Right-click on the *Runner* class.

- Select *Run As*.

- Choose *JUnit Test* to start the tests.

# Notes
- The scenario for searching "BBC News" includes steps to verify the result stats and number of results and seconds. These steps are commented out because they do not appear on the current Google version.
- The scenario for searching non-existent terms is also commented out because the "no results" message does not appear during automation, even though it does appear when performing the search manually. This scenario is kept to show the attempt made.
```
@regression
Scenario: Search for BBC News
  When searching for "BBC News"
  Then results contain "Home - BBC News"
  #And result stats are displayed 
  #And number of "results" is more than 1 
  #And number of "seconds" is more than 0

# @edge
# Scenario: Search for non-existent terms //No results message does not appear through automation
#   Given the user is on the Google search page
#   When the user searches for "$£%$£Qedfxe"
#   Then no relevant search results should be displayed
#   And a message indicating no results found should be shown
```
# Author
Kamal Aitken
