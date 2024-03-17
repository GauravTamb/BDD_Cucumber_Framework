Feature: Trigger Patch_API
@DataDriven
Scenario Outline: Trigger the Patch API request with valid request parameters
		Given Enter "<Name>" and "<Job>" in Patch request body
		When Send the Patch request with data
		Then Validate data_driven_patch status code
		And Validate data_driven_patch response body parameters

Examples: 
		|Name  |Job |
		|Gaurav|QA  |
		|Sakha |SrQA|
		|AustinBotx|Dev|

