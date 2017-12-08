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
 * TransportLogicTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class TransportLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new TransportLogic();
    }

    @Test
    public void testCheckShouldFailWhenNoCommandIsGiven() {
        Assert.assertFalse(underTest.check(null));
    }

    @Test
    public void testCheckShouldReturnTrueWhen() {
        // GIVEN
        final Region coast = new Region();
        coast.setType(RegionType.SEA);
        final Region base = new Region();
        base.setType(RegionType.COASTAL);
        final Region target = new Region();
        target.setType(RegionType.COASTAL);

        coast.getAdjacent().add(base);
        coast.getAdjacent().add(target);

        Unit transporter = new Unit();
        transporter.setType(UnitType.NAVY);
        transporter.setLocation(coast);

        Unit transportee = new Unit();
        transportee.setType(UnitType.ARMY);
        transportee.setLocation(base);
        base.setUnit(transportee);

        Command transportCommand = new Command();
        transportCommand.setType(CommandType.TRANSPORT);
        transportCommand.setUnit(transporter);
        transportCommand.setBase(base);
        transportCommand.setTarget(target);

        // WHEN
        boolean actual = underTest.check(transportCommand);

        // THEN
        Assert.assertTrue(actual);
    }
}