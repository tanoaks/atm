import junit.framework.TestCase;
import model.Denomination;
import model.Parameter;
import model.User;
import model.account.Account;
import model.account.CurrentAccount;

import java.util.List;

public class ATMTest extends TestCase {


    ATM atm;
    Parameter parameter;
    User user;

    public void testDispense() {
        List list = atm.dispense(1000, 1);
        assertEquals(list.size(), 1);
    }

    public void testTestDispense() {
        List list = atm.dispense(1000,user );
        assertEquals(list.size(), 1);

    }

    public void testTestDispense1() {
        List list = atm.dispense(100,10,user );
        assertEquals(((Denomination)list.get(0)).getQty(), 10);
    }

    public void testTestDispense3() {
        List list = atm.dispense(900,user );
        assertEquals(((Denomination)list.get(0)), new Denomination(500,1));
        assertEquals(((Denomination)list.get(1)), new Denomination(200,2));
    }
    public void testTestDispense4() {
        List list = atm.dispense(900,200,user );
        assertEquals(((Denomination)list.get(0)), new Denomination(200,4));
        assertEquals(((Denomination)list.get(1)), new Denomination(100,1));
    }

    public void setUp() throws Exception {

        super.setUp();
        atm = new ATM(10000);
        Account account = new CurrentAccount(1000.00);
        user = new User(account);


    }

    public void tearDown() throws Exception {
    }

    public void testTestDispense2() {
    }


}