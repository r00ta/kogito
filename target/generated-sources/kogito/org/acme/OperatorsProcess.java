package org.acme;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("operators")
public class OperatorsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.OperatorsModel> {

    @javax.inject.Inject()
    javax.enterprise.inject.Instance<org.kie.api.runtime.process.WorkItemHandler> handlers;

    org.kie.kogito.app.Application app;

    public OperatorsProcess() {
    }

    @javax.inject.Inject()
    public OperatorsProcess(org.kie.kogito.app.Application app) {
        super(app.config().process());
        this.app = app;
    }

    public org.acme.OperatorsProcessInstance createInstance(org.acme.OperatorsModel value) {
        return new org.acme.OperatorsProcessInstance(this, value, this.createLegacyProcessRuntime());
    }

    public org.acme.OperatorsProcessInstance createInstance(java.lang.String businessKey, org.acme.OperatorsModel value) {
        return new org.acme.OperatorsProcessInstance(this, value, businessKey, this.createLegacyProcessRuntime());
    }

    public org.acme.OperatorsModel createModel() {
        return new org.acme.OperatorsModel();
    }

    public org.acme.OperatorsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.OperatorsModel) value);
    }

    public org.acme.OperatorsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.OperatorsModel) value);
    }

    public OperatorsProcess configure() {
        super.configure();
        handlers.forEach(h -> {
            services.getWorkItemManager().registerWorkItemHandler(h.getName(), h);
        });
        return this;
    }

    protected void registerListeners() {
    }

    public org.kie.api.definition.process.Process legacyProcess() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("operators");
        factory.variable("available", new ObjectDataType("java.lang.Boolean"), "customTags", null);
        factory.name("Operator Process");
        factory.packageName("org.acme");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.SplitFactory splitNode1 = factory.splitNode(1);
        splitNode1.name("Operator available");
        splitNode1.type(2);
        splitNode1.metaData("UniqueId", "_6755827D-AE84-4BF4-AAD6-7DF7041ACD43");
        splitNode1.metaData("elementname", "Operator available");
        splitNode1.metaData("x", 575);
        splitNode1.metaData("width", 56);
        splitNode1.metaData("y", 364);
        splitNode1.metaData("height", 56);
        splitNode1.constraint(4, "_8C6E009B-093A-4579-8483-6ED8286FF5F8", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean available = (java.lang.Boolean) kcontext.getVariable("available");
            {
                return available;
            }
        }, 0);
        splitNode1.constraint(2, "_BA26BCBC-202C-4BD6-B150-A5C47DF73BF5", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean available = (java.lang.Boolean) kcontext.getVariable("available");
            {
                return !available;
            }
        }, 0);
        splitNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode2 = factory.actionNode(2);
        actionNode2.name("Print Operator not available");
        actionNode2.action(kcontext -> {
            java.lang.Boolean available = (java.lang.Boolean) kcontext.getVariable("available");
            System.out.println("Operator not available");;
        });
        actionNode2.metaData("UniqueId", "_9A1D633D-B092-4A38-94A7-862CE2E7CF84");
        actionNode2.metaData("elementname", "Print Operator not available");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 526);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 527);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode3 = factory.endNode(3);
        endNode3.name("End");
        endNode3.terminate(false);
        endNode3.metaData("UniqueId", "_9B7B135D-4F3E-4911-B51B-C776C0F7D0EA");
        endNode3.metaData("x", 760);
        endNode3.metaData("width", 56);
        endNode3.metaData("y", 550);
        endNode3.metaData("height", 56);
        endNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode4 = factory.actionNode(4);
        actionNode4.name("Print Operator Available");
        actionNode4.action(kcontext -> {
            java.lang.Boolean available = (java.lang.Boolean) kcontext.getVariable("available");
            System.out.println("Operator available!");;
        });
        actionNode4.metaData("UniqueId", "_6486259A-0907-405D-B775-F7CB013A63D2");
        actionNode4.metaData("elementname", "Print Operator Available");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 711);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 341);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory workItemNode5 = factory.workItemNode(5);
        workItemNode5.name("Search Operator");
        workItemNode5.workName("org.acme.OperatorSearchService.isAvailable");
        workItemNode5.workParameter("Interface", "org.acme.OperatorSearchService");
        workItemNode5.workParameter("Operation", "isAvailable");
        workItemNode5.workParameter("interfaceImplementationRef", "org.acme.OperatorSearchService");
        workItemNode5.workParameter("operationImplementationRef", "isAvailable");
        workItemNode5.workParameter("implementation", "Java");
        workItemNode5.outMapping("Result", "available");
        workItemNode5.done();
        workItemNode5.metaData("UniqueId", "_9D08FDC3-8A0A-4573-89B4-BDC3ABD2C6A0");
        workItemNode5.metaData("Implementation", "Java");
        workItemNode5.metaData("elementname", "Search Operator");
        workItemNode5.metaData("Type", "Service Task");
        workItemNode5.metaData("OperationRef", "_9D08FDC3-8A0A-4573-89B4-BDC3ABD2C6A0_ServiceOperation");
        workItemNode5.metaData("x", 341);
        workItemNode5.metaData("width", 154);
        workItemNode5.metaData("y", 341);
        workItemNode5.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode6 = factory.endNode(6);
        endNode6.name("End");
        endNode6.terminate(false);
        endNode6.metaData("UniqueId", "_AE534B3C-69ED-4267-897A-2DE6D0315BB6");
        endNode6.metaData("x", 945);
        endNode6.metaData("width", 56);
        endNode6.metaData("y", 364);
        endNode6.metaData("height", 56);
        endNode6.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory startNode7 = factory.startNode(7);
        startNode7.name("Start");
        startNode7.interrupting(false);
        startNode7.metaData("UniqueId", "_51D03828-5135-4FAB-B930-03EFC73D3B01");
        startNode7.metaData("x", 205);
        startNode7.metaData("width", 56);
        startNode7.metaData("y", 364);
        startNode7.metaData("height", 56);
        startNode7.done();
        factory.connection(5, 1, "_031D7B00-B44D-4687-B0DC-6D0D9F80A16C");
        factory.connection(1, 2, "_BA26BCBC-202C-4BD6-B150-A5C47DF73BF5");
        factory.connection(2, 3, "_9E4BE0F9-59B4-43A6-8E1B-6FC4AED99BC9");
        factory.connection(1, 4, "_8C6E009B-093A-4579-8483-6ED8286FF5F8");
        factory.connection(7, 5, "_6D47B639-2F18-4D68-A918-9AA090DC7357");
        factory.connection(4, 6, "_ABA6F7D2-54CB-4AB2-99C0-4F2BB57D5ABE");
        factory.validate();
        return factory.getProcess();
    }

    public void init(@javax.enterprise.event.Observes() io.quarkus.runtime.StartupEvent event) {
        this.activate();
    }
}
