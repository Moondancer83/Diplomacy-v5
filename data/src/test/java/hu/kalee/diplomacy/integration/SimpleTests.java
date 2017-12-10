package hu.kalee.diplomacy.integration;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.kalee.diplomacy.logic.dto.CommandViewDTO;
import hu.kalee.diplomacy.logic.dto.NationViewDTO;
import hu.kalee.diplomacy.logic.dto.RegionViewDTO;
import hu.kalee.diplomacy.logic.dto.UnitViewDTO;
import hu.kalee.diplomacy.presentation.controller.CommandController;
import hu.kalee.diplomacy.presentation.controller.NationController;
import hu.kalee.diplomacy.presentation.controller.RegionController;
import hu.kalee.diplomacy.presentation.controller.UnitController;

/**
 * SimpleTests.
 *
 * @author mkalinovits
 * @since 2017. 12. 10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTests {
    @Autowired
    private RegionController regionController;
    @Autowired
    private NationController nationController;
    @Autowired
    private UnitController unitController;
    @Autowired
    private CommandController commandController;

    @Test
    @Transactional
    public void testMapSetupIsCorrect() {
        List<RegionViewDTO> regions = regionController.regions();
        Assertions.assertThat(regions).hasSize(14);
        List<NationViewDTO> nations = nationController.nations();
        Assertions.assertThat(nations).hasSize(7);
        List<UnitViewDTO> units = unitController.units();
        Assertions.assertThat(units).hasSize(3);
        List<CommandViewDTO> commands = commandController.commands();
        Assertions.assertThat(commands).hasSize(3);
    }

    @Ignore
    @Test
    @Transactional
    public void test() {
        throw new UnsupportedOperationException();
    }
}
