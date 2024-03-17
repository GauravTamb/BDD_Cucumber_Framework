Feature: Trigger the get APi and validate response parametres
@GetAPI
Scenario: Trigger the APi request with valid request body parametres
          Given Name and Job in get request body	
          When Send the request with payload to the get Endpoint
          Then validate get status code
          
