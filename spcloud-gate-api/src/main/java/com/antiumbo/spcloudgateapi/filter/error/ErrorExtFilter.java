package com.antiumbo.spcloudgateapi.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @author Bran
 * @date 2018/4/30 0030.
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 30;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		ZuulFilter failedFilter = (ZuulFilter) context.get("failed.filter");
		if (failedFilter!=null && failedFilter.filterType().equals("post")){
			return true;
		}
		return false;
	}
}
