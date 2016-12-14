package co.battleship.domain.model.player;

import javafx.beans.binding.ObjectExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jotauribe on 13/12/16.
 */

@RunWith(Parameterized.class)
public class NicknameTest {

    private String validNickname;

    private String invalidNickname;

    public NicknameTest(String validNickname, String invalidNickname){
        this.validNickname = validNickname;
        this.invalidNickname = invalidNickname;
    }

    @Test
    public void newNickname_GivenAValidNickname_ANicknameIsCreated(){
        Nickname nickname = new Nickname(validNickname);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newNickname_GivenAnInvalidNickname_ExceptionThrown(){
        Nickname nickname = new Nickname(invalidNickname);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> provideParameters(){
        List<Object[]> parameters = new ArrayList<>();

        parameters.add(new Object[]{"nickname", ".nickname"});
        parameters.add(new Object[]{"ni", "?nickname"});
        parameters.add(new Object[]{"nicknameeee", "nicknamerrrrrrrrrrrrrrrrrrrrr"});
        parameters.add(new Object[]{"nickname123_", "nickname?090."});

        return parameters;
    }


}