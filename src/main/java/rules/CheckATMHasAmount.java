package rules;

import model.Parameter;

public class CheckATMHasAmount implements Rules<Parameter> {
    @Override
    public boolean apply(Parameter parameter) {
        return parameter.getAvailable_amount()> parameter.getAmount();
    }
}
