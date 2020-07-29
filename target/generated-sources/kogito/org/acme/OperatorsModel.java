package org.acme;

import java.util.Map;
import java.util.HashMap;

@org.kie.internal.kogito.codegen.Generated(value = "kogito-codegen", reference = "operators", name = "Operators", hidden = false)
public class OperatorsModel implements org.kie.kogito.Model {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap();
        params.put("available", this.available);
        return params;
    }

    @Override
    public void fromMap(Map<String, Object> params) {
        fromMap(null, params);
    }

    public void fromMap(String id, Map<String, Object> params) {
        this.id = id;
        this.available = (java.lang.Boolean) params.get("available");
    }

    @org.kie.internal.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "available")
    private java.lang.Boolean available;

    public java.lang.Boolean getAvailable() {
        return available;
    }

    public void setAvailable(java.lang.Boolean available) {
        this.available = available;
    }
}
