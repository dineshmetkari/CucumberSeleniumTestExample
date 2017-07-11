@DemoHomeSearchMouse
Feature: Accessing the Demo site using a search field  

	Background:
		Given that the Demo site has been accessed
 
    @COMPLETE
    	Scenario: I want to verify there is a search field that will produce a search for the word "mouse"
    
    	Then Verify that there is a search field that will produce a search for the word "mouse"