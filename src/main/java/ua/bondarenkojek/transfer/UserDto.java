package ua.bondarenkojek.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String userName;
    private List<Task> taskList;

    public static UserDto from(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .taskList(user.getTaskList())
                .build();
    }
}
