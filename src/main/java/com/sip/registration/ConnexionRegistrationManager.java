package com.sip.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConnexionRegistrationManager {
    Map<String, String> regMap = new HashMap<>();
    @Value("${registration.dump.file.path}")
    private String REGS_FILE;
    private ObjectMapper mapper = new ObjectMapper();

    public void loadAORData() throws IOException {
        File file = new File(REGS_FILE);
        if (!file.exists()) {
            throw new RuntimeException("File not found: " + REGS_FILE);
        }
        List<RegistrationData> regDataList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, RegistrationData.class));
        for (RegistrationData regData : regDataList) {
            regMap.put(regData.getAddressOfRecord(), mapper.writeValueAsString(regData));
        }
    }

    public String retrieveAOPConnection(String aop) {
        return this.regMap.getOrDefault(aop.trim(), "");
    }
}
