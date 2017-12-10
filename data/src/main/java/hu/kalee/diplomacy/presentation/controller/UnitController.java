package hu.kalee.diplomacy.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.kalee.diplomacy.logic.dto.UnitViewDTO;
import hu.kalee.diplomacy.logic.facade.UnitFacade;

/**
 * UnitController.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@RestController
public class UnitController {
    @Autowired
    private UnitFacade facade;

    @RequestMapping(value = "units", method = RequestMethod.GET)
    public List<UnitViewDTO> getUnits() {
        return facade.getUnits();
    }
}
