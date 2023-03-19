package com.sip.registration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationData {
    @JsonProperty("addressOfRecord")
    private String addressOfRecord;

    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("contact")
    private String contact;

    @JsonProperty("path")
    private String[] path;

    @JsonProperty("source")
    private String source;

    @JsonProperty("target")
    private String target;

    @JsonProperty("userAgent")
    private String userAgent;

    @JsonProperty("rawUserAgent")
    private String rawUserAgent;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lineId")
    private String lineId;

    public String getAddressOfRecord() {
        return addressOfRecord;
    }
}
