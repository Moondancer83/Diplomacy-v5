package hu.kalee.diplomacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.converter.CommandEntityToViewDTOConverter;
import hu.kalee.diplomacy.domain.Command;
import hu.kalee.diplomacy.dto.CommandViewDTO;
import hu.kalee.diplomacy.repository.CommandRepository;

/**
 * CommandController.
 *
 * @author mkalinovits
 * @since 2017. 12. 04.
 */
@RestController
public class CommandController {
    @Autowired
    private CommandRepository repository;
    @Autowired
    private CommandEntityToViewDTOConverter converter;

    @RequestMapping(value = "commands")
    public List<CommandViewDTO> commands() {
        return Lists.transform((List<Command>) repository.findAll(), converter::convert);
    }
}
