package com.epam.catalog.controller;

import com.epam.catalog.bean.Request;
import com.epam.catalog.bean.Response;
import com.epam.catalog.controller.exception.ControllerException;

/**
 * Created by PC on 31.01.2017.
 */
public interface Command {
    Response execute(Request request) throws ControllerException;
}
