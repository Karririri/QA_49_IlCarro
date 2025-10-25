package data_transfer_object;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
