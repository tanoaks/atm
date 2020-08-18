package rules;

import model.Parameter;

public class CheckUserAccountEligible implements Rules<Parameter>{
    @Override
    public boolean apply(Parameter parameter) {
       double userBalance= parameter.getUser().getAccount().balance();
        return userBalance>=parameter.getAmount();
    }
}
