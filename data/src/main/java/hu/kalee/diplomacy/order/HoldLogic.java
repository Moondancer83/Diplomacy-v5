package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;

/**
 * HoldLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class HoldLogic extends AbstractCommandLogic implements CommandLogic {

    @Override
    protected boolean specificChecks(final Command command) {
        return true;
    }
}
