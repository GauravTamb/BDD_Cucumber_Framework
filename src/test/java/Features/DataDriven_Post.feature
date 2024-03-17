Feature: Trigger Post_API
@DataDriven
Scenario Outline: Trigger the post API request with valid request parameters
		Given Enter "<Name>" and "<Job>" in post request body
		When Send the post request with data
		Then Validate data_driven_post status code
		And Validate data_driven_post response body parameters

Examples: 
		|Name  |Job |
		|Gaurav|QA  |
		|Sakha |SrQA|
		|AustinBotx|Dev|

