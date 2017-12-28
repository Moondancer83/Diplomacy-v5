package hu.kalee.diplomacy.logic.order;

import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.data.domain.Command;

/**
 * HoldLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
@Component
public class HoldLogic extends AbstractCommandLogic implements CommandLogic {

    @Override
    protected boolean specificChecks(final Command command) {
        return true;
    }
}
