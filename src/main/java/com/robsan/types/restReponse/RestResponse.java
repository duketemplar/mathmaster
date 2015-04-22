package com.robsan.types.restReponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lordofeverything on 28/12/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestResponse {

    private static final long serialVersionUID = 1L;

    @XmlElement
    @JsonProperty
    private Integer sid;

    @XmlElement
    @JsonProperty
    private RestResponseCode errorCode;

    @XmlElement
    @JsonProperty
    private String errorText;


    public RestResponse(Integer sid) {
        this.sid = sid;
    }

    public RestResponse(RestResponseCode errorCode, String errorText) {
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public RestResponseCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(RestResponseCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
