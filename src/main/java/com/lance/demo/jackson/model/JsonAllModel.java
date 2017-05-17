package com.lance.demo.jackson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lance.demo.jackson.JsonPaySerialize;
import com.lance.demo.jackson.annotation.FormRequest;
import com.lance.demo.jackson.annotation.HeaderEncrypt;
import lombok.Data;

/**
 * Created by perdonare on 2017/5/15.
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@FormRequest
//@HeaderEncrypt
public class JsonAllModel<T> {
    private String terminalId;

    private String memberId;

    private String dataType;

    private String version;

    @JsonSerialize(using = JsonPaySerialize.class)
    private T dataContent;

}
