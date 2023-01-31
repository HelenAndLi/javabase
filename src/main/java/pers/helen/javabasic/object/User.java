package pers.helen.javabasic.object;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private long userId;

    private String username;

    @Override
    public String toString(){
        return this.getClass() + "[userId=" + userId + ",username=" + username + "]";
    }
}
