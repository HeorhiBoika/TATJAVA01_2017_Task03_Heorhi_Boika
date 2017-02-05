package com.epam.catalog.controller;

import com.epam.catalog.controller.exception.ControllerException;
import com.epam.catalog.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PC on 31.01.2017.
 */
public class CommandProvider {
    private Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.CONTENT_CATALOG, new ContentCatalog());
        repository.put(CommandName.ADD_PRODUCT, new AddNewProduct());
        repository.put(CommandName.FIND_BY_TYPE, new FindByType());
        repository.put(CommandName.FIND_BY_NAME, new FindByName());
        repository.put(CommandName.FIND_BY_GENRE, new FindByGenre());
        repository.put(CommandName.GET_CATALOG, new GetCatalog());
    }

    Command getCommand(String name) throws ControllerException {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name);
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ControllerException("Wrong command");
        }
        return command;
    }

}
