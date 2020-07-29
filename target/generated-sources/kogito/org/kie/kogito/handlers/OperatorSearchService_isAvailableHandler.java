package org.kie.kogito.handlers;

@javax.enterprise.context.ApplicationScoped()
public class OperatorSearchService_isAvailableHandler implements org.kie.api.runtime.process.WorkItemHandler {

    @javax.inject.Inject()
    org.acme.OperatorSearchService service;

    public void executeWorkItem(org.kie.api.runtime.process.WorkItem workItem, org.kie.api.runtime.process.WorkItemManager workItemManager) {
        java.lang.Object result = service.isAvailable();
        workItemManager.completeWorkItem(workItem.getId(), java.util.Collections.singletonMap("Result", result));
    }

    public void abortWorkItem(org.kie.api.runtime.process.WorkItem workItem, org.kie.api.runtime.process.WorkItemManager workItemManager) {
    }

    public String getName() {
        return "org.acme.OperatorSearchService.isAvailable";
    }
}
