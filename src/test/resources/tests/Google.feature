Feature: Google

  Background:
    Given url "http://www.google.co.uk" is launched

  @regression
  Scenario: Mission statement can be seen
    When About page is shown
    Then page displays "Our mission is to organise the world’s information and make it universally accessible and useful"

	@regression
  Scenario: Use "I'm Feeling Lucky" for a search term
    Given the user is on the Google search page
    When the user searches for "cat" using I'm Feeling Lucky
    Then the user should be directly taken to the top result page

  @regression
  Scenario: Search for BBC News
    When searching for "BBC News"
    Then results contain "Home - BBC News"
    #And result stats are displayed //results not appearing on current google version
    #And number of "results" is more than 1 
    #And number of "seconds" is more than 0

#	@edge
  #Scenario: Search for non-existent terms //No results message does not appear through automation
    #Given the user is on the Google search page
    #When the user searches for "$£%$£Qedfxe"
    #Then no relevant search results should be displayed
    #And a message indicating no results found should be shown
    
