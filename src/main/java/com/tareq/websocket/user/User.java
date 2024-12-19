package com.tareq.websocket.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String name;

    private String imgUrl;

    private String phnNumber;

    private String address;

    @Indexed(unique = true)
    private String email;

    private String password;

    private boolean enabled;

    private boolean online;
}
