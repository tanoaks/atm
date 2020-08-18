package rules;

import model.Parameter;

public class PrefrenceInSupported implements Rules<Parameter> {
    @Override
    public boolean apply(Parameter parameter) {
        if (parameter.getPreference() == -1)
            return true;
        return parameter.getSupported().contains(parameter.getPreference());
    }
}
