package hu.kalee.diplomacy.logic.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.CommandType;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.domain.UnitType;

/**
 * SupportLogicTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class SupportLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new SupportLogic();
    }

    @Test
    public void testCheckShouldFailWhenNoCommandIsGiven() {
        Assert.assertFalse(underTest.check(null));
    }

    @Test
    public void test() {
        // GIVEN
        final Region location = new Region();
        location.setType(RegionType.SEA);
        final Region base = new Region();
        base.setType(RegionType.COASTAL);
        final Region target = new Region();
        target.setType(RegionType.COASTAL);

        location.getAdjacent().add(base);
        location.getAdjacent().add(target);

        Unit supporter = new Unit();
        supporter.setType(UnitType.NAVY);
        supporter.setLocation(location);

        Unit supported = new Unit();
        supported.setType(UnitType.ARMY);
        supported.setLocation(base);
        base.setUnit(supported);

        Command transportCommand = new Command();
        transportCommand.setType(CommandType.SUPPORT);
        transportCommand.setUnit(supporter);
        transportCommand.setBase(base);
        transportCommand.setTarget(target);

        Command moveCommand = new Command();
        moveCommand.setType(CommandType.MOVE);
        moveCommand.setTarget(target);
        moveCommand.setUnit(supported);
        supported.setCommand(moveCommand);

        // WHEN
        boolean actual = underTest.check(transportCommand);

        // THEN
        Assert.assertTrue(actual);
    }
}