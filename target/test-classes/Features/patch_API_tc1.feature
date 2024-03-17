Feature: Trigger the patch APi and validate response parametres
@PatchAPI
Scenario: Trigger the APi request with valid request body parametres
          Given Name and Job in patch request body	
          When Send the request with payload to the patch Endpoint
          Then validate patch status code
          And validate patch response body parametres
