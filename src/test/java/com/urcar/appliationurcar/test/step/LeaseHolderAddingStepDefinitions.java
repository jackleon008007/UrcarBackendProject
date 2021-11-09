package com.urcar.appliationurcar.test.step;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urcar.appliationurcar.userAdministration.resource.CreateLeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.CreateLessorResource;
import com.urcar.appliationurcar.userAdministration.resource.LeaseHolderResource;
import com.urcar.appliationurcar.userAdministration.resource.LessorResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaseHolderAddingStepDefinitions {
    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int randomServerPort;
    private String endpointPath;
    private ResponseEntity<String> responseEntity;

    @Given("The Endpoint2 {string} is Available")
    public void theEndPointIsAvailable(String endpointPath){
        this.endpointPath= String.format(endpointPath,randomServerPort);
    }


    @When("A LeaseHolder Request is sent with values {string},{string},{long},{long},{string},{string},{string},{string},{long},{string},{string},{string},{long},{string},{string},{long},{string}")
    public void aLeaseHolderRequestIsSentWithValues(String name, String lastname, Long dni,
                                               Long age, String address, String type,
                                               String password, String imageprofile,
                                               Long numberphone, String email, String licenseplate,
                                               String district, Long postalcode, String experience,
                                               String recomends, Long driverlicense,
                                               String paymethos ){

        CreateLeaseHolderResource resource = new CreateLeaseHolderResource()
                .withName(name)
                .withLastName(lastname)
                .withDni(dni)
                .withAge(age)
                .withAddress(address)
                .withType(type)
                .withPassword(password)
                .withImageProfile(imageprofile)
                .withNumberPhone(numberphone)
                .withEmail(email)
                .withLicensePlate(licenseplate)
                .withDistrict(district)
                .withPostalCode(postalcode)
                .withExperience(experience)
                .withRecomends(recomends)
                .withDriverlicense(driverlicense)
                .withPayMethods(paymethos);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateLeaseHolderResource> request =new HttpEntity<>(resource,headers);
        responseEntity =testRestTemplate.postForEntity(endpointPath,request,String.class);

    }
    @Then("A Response2 with status {int} is received")
    public void aResponseWithExpectedStatusIsReceived(int expectedStatusCode){
        int actualStatusCode= responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }

    @And("A LeaseHolder Resource with values {string},{string},{long},{long},{string},{string},{string},{string},{long},{string},{string},{string},{long},{string},{string},{long},{string} is included in Response Body")
    public void aLeaseHolderResourceWithValuesIsIncludedInResponseBody(String name, String lastname, Long dni,
                                                                  Long age, String address, String type,
                                                                  String password, String imageprofile,
                                                                  Long numberphone, String email, String licenseplate,
                                                                  String district, Long postalcode, String experience,
                                                                  String recomends, Long driverlicense,
                                                                  String paymethos ){

        LeaseHolderResource expectedResource = new LeaseHolderResource()
                .withName(name)
                .withLastName(lastname)
                .withDni(dni)
                .withAge(age)
                .withAddress(address)
                .withType(type)
                .withPassword(password)
                .withImageProfile(imageprofile)
                .withNumberPhone(numberphone)
                .withEmail(email)
                .withLicensePlate(licenseplate)
                .withDistrict(district)
                .withPostalCode(postalcode)
                .withExperience(experience)
                .withRecomends(recomends)
                .withDriverlicense(driverlicense)
                .withPayMethods(paymethos);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        LeaseHolderResource actualResource;
        try{
            actualResource =mapper.readValue(value,LeaseHolderResource.class);
        }catch(JsonProcessingException | NullPointerException e){
            actualResource = new LeaseHolderResource();
        }

        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);

    }

}
