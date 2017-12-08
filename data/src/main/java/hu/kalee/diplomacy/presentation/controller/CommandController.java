package hu.kalee.diplomacy.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.kalee.diplomacy.logic.dto.CommandViewDTO;
import hu.kalee.diplomacy.logic.facade.CommandFacade;

/**
 * CommandController.
 *
 * @author mkalinovits
 * @since 2017. 12. 04.
 */
@RestController
public class CommandController {
    @Autowired
    private CommandFacade facade;

    @RequestMapping(value = "commands")
    public List<CommandViewDTO> commands() {
        return facade.getCommands();
    }
}
