package com.iri.spring.service.mapper;

import com.iri.spring.dto.UserResponseDto;
import com.iri.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto convertToDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        return userDto;
    }
}
