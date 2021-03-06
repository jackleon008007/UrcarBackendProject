package com.urcar.appliationurcar.userAdministration.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("userAdministrationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public LessorMapper lessorMapper(){
        return new LessorMapper();
    }
    @Bean
    public LeaseHolderMapper leaseHolderMapper(){
        return new LeaseHolderMapper();
    }
}
