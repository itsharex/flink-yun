package com.isxcode.acorn.api.alarm.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EnableMessageReq {

    @Schema(title = "消息体id", example = "fy_123")
    @NotEmpty(message = "消息体id不能为空")
    private String id;
}