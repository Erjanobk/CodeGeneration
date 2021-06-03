package io.swagger.model;
import lombok.*;
import javax.persistence.*;


public class UserDB {
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Data
    public class dbUser {
        @Id
        @GeneratedValue
        private Integer userId;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String UserTypeEnum;
    }

}
