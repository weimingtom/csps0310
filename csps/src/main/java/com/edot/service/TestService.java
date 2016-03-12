package com.edot.service;

import com.edot.api.response.TestListResponse;
import com.edot.web.request.TestEditReqeust;

import java.util.List;

public interface TestService {
	
	public List<TestListResponse> list() throws Exception;

	public TestListResponse detail(Long userId) throws Exception;
	
	public TestListResponse edit(TestEditReqeust request) throws Exception;

	public void deleteById(Long id) throws Exception;
}
