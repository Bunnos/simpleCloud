package com.antiumbo.spcloudgateapi.filter.error;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author Bran
 * @date 2018/4/30 0030.
 */
public class DidiErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
		result.remove("exception");
		return result;
	}
}
