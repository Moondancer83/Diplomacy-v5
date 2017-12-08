package hu.kalee.diplomacy.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.logic.converter.UnitEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.UnitViewDTO;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.repository.UnitRepository;

/**
 * UnitController.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@RestController
public class UnitController {
    @Autowired
    private UnitRepository repository;
    @Autowired
    private UnitEntityToViewDTOConverter converter;

    @RequestMapping(value = "units", method = RequestMethod.GET)
    public List<UnitViewDTO> getUnits() {
        return Lists.transform((List<Unit>) repository.findAll(), converter::convert);
    }
}
