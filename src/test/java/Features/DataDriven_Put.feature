Feature: Trigger Put_API
@DataDriven
Scenario Outline: Trigger the put API request with valid request parameters
		Given Enter "<Name>" and "<Job>" in put request body
		When Send the put request with data
		Then Validate data_driven_put status code
		And Validate data_driven_put response body parameters

Examples: 
		|Name  |Job |
		|Gaurav|QA  |
		|Sakha |SrQA|
		|AustinBotx|Dev|

