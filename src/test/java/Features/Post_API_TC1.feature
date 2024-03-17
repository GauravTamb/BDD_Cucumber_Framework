Feature: Trigger the post APi and validate response parametres

@PostAPI
Scenario: Trigger the APi request with valid request body parametres
          Given Name and Job in post request body	
          When Send the request with payload to the post Endpoint
          Then validate post status code
          And validate post response body parametres
