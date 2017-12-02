package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;

/**
 * SupportLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class SupportLogic extends AbstractCommandLogic implements CommandLogic {
    @Override
    protected boolean specificChecks(final Command command) {
        return false;
    }
}
