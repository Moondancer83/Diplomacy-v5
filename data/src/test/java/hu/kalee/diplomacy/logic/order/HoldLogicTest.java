package hu.kalee.diplomacy.logic.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.CommandType;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;

/**
 * HoldLogicTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class HoldLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new HoldLogic();
    }

    @Test
    public void testCheckShouldFailWhenNoCommandIsGiven() {
        Assert.assertFalse(underTest.check(null));
    }

    @Test
    public void testCheckShouldReturnTrue() {
        final Command holdCommand = new Command();
        holdCommand.setType(CommandType.HOLD);
        Unit unit = new Unit();
        holdCommand.setUnit(unit);
        final Region location = new Region();
        holdCommand.setBase(location);
        holdCommand.setTarget(location);
        Assert.assertTrue(underTest.check(holdCommand));
    }
}
