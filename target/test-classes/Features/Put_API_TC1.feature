Feature: Trigger the put APi and validate response parametres
@PutAPI
Scenario: Trigger the APi request with valid request body parametres
          Given Name and Job in put request body	
          When Send the request with payload to the put Endpoint
          Then validate put status code
          And validate put response body parametres
