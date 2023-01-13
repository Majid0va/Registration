package com.atl.register.mpper;
import com.atl.register.dto.UserDto;
import com.atl.register.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "firstName"),
            @Mapping(target = "lastName"),
            @Mapping(target = "password"),
            @Mapping(target = "email")})
    UserDto modelToDto(User user);


    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "firstName"),
            @Mapping(target = "lastName"),
            @Mapping(target = "password"),
            @Mapping(target = "email")})
    User dtoToModel(UserDto userDto);
}
