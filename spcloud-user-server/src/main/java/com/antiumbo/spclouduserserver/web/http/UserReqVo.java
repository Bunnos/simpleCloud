package com.antiumbo.spclouduserserver.web.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Bran
 * @date 2018/4/23 0023.
 */
@Data
@ApiModel(value = "UserReqVo",description = "用户请求实体类")
public class UserReqVo implements Serializable {
	private static final long serialVersionUID = -4333316296251054416L;

	@ApiModelProperty(value = "名字")
	private String name;
	@ApiModelProperty(value = "密码")
	private String password;
}
