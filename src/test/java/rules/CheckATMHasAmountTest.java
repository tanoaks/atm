package rules;

import junit.framework.TestCase;
import model.Parameter;
import model.User;
import model.account.Account;
import model.account.CurrentAccount;

import java.util.List;

public class CheckATMHasAmountTest extends TestCase {
    Parameter parameter;
    CheckATMHasAmount checkATMHasAmount;

    public void setUp() throws Exception {
        Account account = new CurrentAccount(1000.00);
        checkATMHasAmount = new CheckATMHasAmount();

        User user = new User(account);
        parameter = new Parameter(user, 100, 10000, List.of(10, 20), 10);

        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testApply() {
        assertEquals(checkATMHasAmount.apply(parameter), true);
    }

    public void testApplyNegative() {
        parameter.setAmount(1000000);
        assertEquals(checkATMHasAmount.apply(parameter), false);
    }
}