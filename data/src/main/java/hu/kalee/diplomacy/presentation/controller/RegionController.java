package hu.kalee.diplomacy.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.kalee.diplomacy.logic.dto.RegionViewDTO;
import hu.kalee.diplomacy.logic.facade.RegionFacade;

/**
 * RegionController.
 *
 * @author mkalinovits
 * @since 2017. 12. 04.
 */
@RestController
public class RegionController {
    @Autowired
    private RegionFacade facade;

    @RequestMapping(value = "regions")
    public List<RegionViewDTO> regions() {
        return facade.getRegions();
    }
}
