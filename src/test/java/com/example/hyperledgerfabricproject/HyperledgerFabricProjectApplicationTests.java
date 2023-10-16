package com.example.hyperledgerfabricproject;

import com.example.hyperledgerfabricproject.vo.ResultObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyperledger.fabric.gateway.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

@SpringBootTest
class HyperledgerFabricProjectApplicationTests {

//    @Test
//    void contextLoads() throws IOException {
//
//        ResultObject ro = new ResultObject();
//        JsonNode resultNode;
//        Path walletDirectory = Paths.get("wallet");
//        Wallet wallet = Wallet.createFileSystemWallet(walletDirectory);
//        Path networkConfigFile = Paths.get("wallet/connection.json");
//        System.out.println(networkConfigFile);
//
//        Gateway.Builder builder = Gateway.createBuilder()
//                .identity(wallet, "user1")
//                .networkConfig(networkConfigFile)
//                .discovery(false);
//        try {
////                // Obtain a smart contract deployed on the network.
//            Gateway gateway = builder.connect();
//            System.out.println(gateway.getIdentity());
//            Network network = gateway.getNetwork("mychannel");
//            Contract contract = network.getContract("fabcar");
//            byte[] createCarResult = contract.submitTransaction("queryCar", "CAR4");
//            String result = new String(createCarResult, StandardCharsets.UTF_8);
////
//            System.out.println("result : " + result);
//                ObjectMapper mapper = new ObjectMapper();
//                resultNode = mapper.readTree(result);
//                ro.setJsonNode(resultNode);
//                ro.setGateway(gateway);
//                System.out.println("gateway hash : " + gateway.hashCode());
//        } catch (ContractException | TimeoutException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
