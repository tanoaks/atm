import model.Denomination;
import model.Parameter;
import model.User;
import rules.CheckATMHasAmount;
import rules.CheckUserAccountEligible;
import rules.PrefrenceInSupported;
import rules.Rules;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private int available_amount;
    static List<Integer> supported;

    static List<Rules> applyRules;

    static {
        supported = List.of(10, 20, 50, 100, 200, 500, 1000);
        applyRules =
                List.of(new CheckATMHasAmount(),
                        new CheckUserAccountEligible(),
                        new PrefrenceInSupported());
    }

    ATM(int amount) {
        this.available_amount = amount;
    }



    List<Denomination> dispense(int amount, int preference, User user) {
        Parameter parameter =
                new Parameter(user, amount, available_amount, supported, preference);
        boolean result = applyRules.stream().map(x -> x.apply(parameter))
                .reduce(true, (x, y) -> x & y);
        if (result) {
            int index = supported.indexOf(preference);
            user.getAccount().debit(amount);
            return dispense(amount, index);

        } else {
            throw new RuntimeException("ATM is Unable To process Request");
        }

    }


    List<Denomination> dispense(int amount, User user) {
        List<Denomination> calculated = new ArrayList<>();
        Parameter parameter =
                new Parameter(user, amount, available_amount, supported, -1);
        boolean result = applyRules.stream().map(x -> x.apply(parameter))
                .reduce(true, (x, y) -> x & y);
        if (result) {
            user.getAccount().debit(amount);
            for (int i = supported.size() - 1; i >= 0; i--) {
                if (amount / supported.get(i) > 0) {
                    return dispense(amount, i);
                }

            }
        }
        return calculated;
    }

    List<Denomination> dispense(int amount, int index) {
        List<Denomination> calculated = new ArrayList<>();

        for (int i = index; i >= 0; i--) {
            if (amount > 0) {
                int count = amount / supported.get(i);
                amount = amount % supported.get(i);
                Denomination current = new Denomination();
                current.setQty(count);
                current.setValue(supported.get(i));
                calculated.add(current);
            } else
                break;


        }
        if (amount > 0) {
            throw new RuntimeException("Amount could not be dispensed");
        }
        return calculated;
    }


}
