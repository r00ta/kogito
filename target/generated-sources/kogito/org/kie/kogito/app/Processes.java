package org.kie.kogito.app;

public class Processes implements org.kie.kogito.process.Processes {

    private final Application application;

    public Processes(Application application) {
        this.application = application;
    }

    public org.kie.kogito.process.Process<? extends org.kie.kogito.Model> processById(String processId) {
        if ("operators".equals(processId))
            return new org.acme.OperatorsProcess(application).configure();
        return null;
    }

    public java.util.Collection<String> processIds() {
        return java.util.Arrays.asList("operators");
    }
}
