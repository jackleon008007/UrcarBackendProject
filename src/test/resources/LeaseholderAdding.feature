
Feature: LeaseHolder Adding
  As a Developer
  I want to add LeaseHolder through API
  So that It can available to applications.


  Background:
    Given The Endpoint2 "http://localhost:%d/api/v1/leaseHolder" is Available


  @leaseholder-adding
  Scenario: Add LeaseHolder
    When A LeaseHolder Request is sent with values "Homero","Madeira",125545546,39,"jr.los barracones","basico","123","imagen_direccion",123456789,"welom@gmail.com","AWSE-13","surco",1245553,"senior","good person",1354,"cash"
    Then A Response2 with status 200 is received
    And A LeaseHolder Resource with values "Homero","Madeira",125545546,39,"jr.los barracones","basico","123","imagen_direccion",123456789,"welom@gmail.com","AWSE-13","surco",1245553,"senior","good person",1354,"cash" is included in Response Body
