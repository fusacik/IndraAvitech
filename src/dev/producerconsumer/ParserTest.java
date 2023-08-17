package dev.producerconsumer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void parserTest(){

        String command =   "Add(1, 'a1', 'Robert')";
        User expectedUser = new User(1, "a1", "Robert");
        User actualUser = Parser.parseCommand(command);
        assertEquals(expectedUser.getUserId() ,actualUser.getUserId());
        assertEquals(expectedUser.getUserGuid() ,actualUser.getUserGuid());
        assertEquals(expectedUser.getUserName() ,actualUser.getUserName());

    }

}