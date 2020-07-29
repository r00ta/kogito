package org.acme;

public class OperatorsProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<OperatorsModel> {

    public OperatorsProcessInstance(org.acme.OperatorsProcess process, OperatorsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public OperatorsProcessInstance(org.acme.OperatorsProcess process, OperatorsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    protected java.util.Map<String, Object> bind(OperatorsModel variables) {
        return variables.toMap();
    }

    protected void unbind(OperatorsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
