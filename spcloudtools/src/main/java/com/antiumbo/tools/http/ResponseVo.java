package com.antiumbo.tools.http;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 默柴柒柒
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo implements Serializable {
	private static final long serialVersionUID = -4333316296251054426L;

	/**
	 * CONSTANTS
	 */
	private static final int SUCCESS = 200;
	private static final int FAILURE = 300;
	private static final String SUCCESS_MSG = "success";
	private static final String FAILURE_MSG = "failure";

	/**
	 * PARAMS
	 */
	private int code;
	private String msg;
	private Object data;

	public static ResponseVo successResponse() {
		return new ResponseVo(SUCCESS, SUCCESS_MSG, null);
	}

	public static ResponseVo successResponse(String key, Object value) {
		Map map = Maps.newLinkedHashMap();
		map.put(key, value);
		return new ResponseVo(SUCCESS, SUCCESS_MSG, map);
	}

	public static ResponseVo failureResponse() {
		return new ResponseVo(FAILURE, FAILURE_MSG, null);
	}

	public static ResponseVo failureResponse(String failureMsg) {
		return new ResponseVo(FAILURE, failureMsg, null);
	}
}
