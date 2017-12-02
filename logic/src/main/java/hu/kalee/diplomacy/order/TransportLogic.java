package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;

/**
 * TransportLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class TransportLogic extends AbstractCommandLogic implements CommandLogic {
    @Override
    protected boolean specificChecks(final Command command) {
        return false;
    }
}
