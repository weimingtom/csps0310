package com.edot.service.impl;

import cn.wltg.http.HttpApiClient;
import com.edot.api.ApiUrls;
import com.edot.api.response.TestListResponse;
import com.edot.service.TestService;
import com.edot.web.request.TestEditReqeust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
    private HttpApiClient httpApiClient;
	
	@Override
	public List<TestListResponse> list() throws Exception {
		List<TestListResponse> response = httpApiClient.get(ApiUrls.TEST_LIST, null, List.class);
		return response;
	}

	@Override
	public TestListResponse detail(Long userId) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("user_id", userId);
		TestListResponse response = httpApiClient.get(ApiUrls.TEST_DETAIL, params, TestListResponse.class);
		return response;
	}

	@Override
	public TestListResponse edit(TestEditReqeust request) throws Exception {
		TestListResponse response = httpApiClient.post(ApiUrls.TEST_EDIT, request, TestListResponse.class);
		return response;
	}

	@Override
	public void deleteById(Long userId) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("user_id", userId);
		httpApiClient.get(ApiUrls.TEST_DELETE, params, TestListResponse.class);
	}
}
