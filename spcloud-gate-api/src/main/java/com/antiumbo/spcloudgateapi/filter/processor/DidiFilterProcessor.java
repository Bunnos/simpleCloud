package com.antiumbo.spcloudgateapi.filter.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author Bran
 * @date 2018/4/30 0030.
 */
public class DidiFilterProcessor extends FilterProcessor {
	@Override
	public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
		try {
			return super.processZuulFilter(filter);
		} catch (ZuulException e) {
			RequestContext context = RequestContext.getCurrentContext();
			context.set("failed.filter", filter);
			throw e;
		}
	}
}
