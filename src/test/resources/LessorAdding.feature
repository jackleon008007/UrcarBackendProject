
  Feature: Lessor Adding
    As a Developer
    I want to add Lessor through API
    So that It can available to applications.


    Background:
      Given The Endpoint "http://localhost:%d/api/v1/lessor" is Available


    @post-adding
      Scenario: Add Lessor
        When A Lessor Request is sent with values "Cristiano","Madeira",123546546,35,"jr.los bosques","basico","123","imagen_direccion",123456789,"welom@gmail.com","AWSE-13","Comas",12455535,"senior","good person",13546,"cash"
        Then A Response with status 200 is received
        And A Lessor Resource with values "Cristiano","Madeira",123546546,35,"jr.los bosques","basico","123","imagen_direccion",123456789,"welom@gmail.com","AWSE-13","Comas",12455535,"senior","good person",13546,"cash" is included in Response Body
