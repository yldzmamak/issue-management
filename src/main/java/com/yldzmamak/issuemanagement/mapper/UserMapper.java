package com.yldzmamak.issuemanagement.mapper;

import com.yldzmamak.issuemanagement.dto.UserDto;
import com.yldzmamak.issuemanagement.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring",uses = {IssueMapper.class})
public interface UserMapper {
    @Named("toUser")
    User toUser(UserDto projectDto);

    @Named("toProjectDto")
    UserDto toUserDto(User project);

    @IterableMapping(qualifiedByName = "toUser")
    List<User> toUserList(List<UserDto> projectDtoList);

    @IterableMapping(qualifiedByName = "toProjectDto")
    List<UserDto> toUserDtoList(List<User> projectList);
}
