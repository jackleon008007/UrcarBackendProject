package com.urcar.appliationurcar.publications.mapping;


import com.urcar.appliationurcar.shared.mapping.EnhancedModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("publicatonsMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PostMapper postMapper(){
        return new PostMapper(new EnhancedModelMapper());
    }
    @Bean
    public CommentMapper commentMapper(){
        return new CommentMapper(new EnhancedModelMapper());
    }

    @Bean
    public ReservationMapper reservationMapper(){
        return new ReservationMapper(new EnhancedModelMapper());
    }

}
