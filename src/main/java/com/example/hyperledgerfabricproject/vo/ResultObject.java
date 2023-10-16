package com.example.hyperledgerfabricproject.vo;

import com.fasterxml.jackson.databind.JsonNode;
import org.hyperledger.fabric.gateway.Gateway;

public class ResultObject {
        private JsonNode j;
        private Gateway g;
        public void setJsonNode(JsonNode json) {
            j = json;
        }
        public void setGateway(Gateway gateway) {
            g = gateway;
        }
        public JsonNode getJsonNode() {
            return j;
        }
        public Gateway getGateway() {
            return g;
        }


}
