package com.example.hyperledgerfabricproject.chainApi;

import com.example.hyperledgerfabricproject.vo.ResultObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyperledger.fabric.gateway.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@RestController
public class ChainApi {

    @GetMapping("/car")
    public Map<String, Object> getOneCar() throws IOException {

            Map<String, Object> result = new HashMap<>();
            ResultObject ro = new ResultObject();
            JsonNode resultNode;
            Path walletDirectory = Paths.get("wallet");
            Wallet wallet = Wallet.createFileSystemWallet(walletDirectory);
            Path networkConfigFile = Paths.get("wallet/connection.json");
            System.out.println(networkConfigFile);

            Gateway.Builder builder = Gateway.createBuilder()
                    .identity(wallet, "user1")
                    .networkConfig(networkConfigFile)
                    .discovery(false);
            try {
//                // Obtain a smart contract deployed on the network.
                Gateway gateway = builder.connect();
                System.out.println(gateway.getIdentity());
                Network network = gateway.getNetwork("mychannel");
                Contract contract = network.getContract("fabcar");
                byte[] createCarResult = contract.submitTransaction("queryCar", "CAR4");
                String getResult = new String(createCarResult, StandardCharsets.UTF_8);

                System.out.println("result : " + getResult);
                ObjectMapper mapper = new ObjectMapper();
                resultNode = mapper.readTree(getResult);
                ro.setJsonNode(resultNode);
                ro.setGateway(gateway);
                ro.getGateway().close();
                result.put("resultCode", true);
                result.put("data", getResult);
                return result;

            } catch (ContractException | TimeoutException | InterruptedException e) {
                e.printStackTrace();
                result.put("resultCode", false);
                return result;
            }
    }
}
