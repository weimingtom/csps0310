package com.edot.support.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Created by tony on 16/3/2.
 */
public class EdotInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

//    private SysUrlService sysUrlService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public EdotInvocationSecurityMetadataSource() {
//        this.sysUrlService = sysUrlService;
        loadResourceDefine();
    }
//
    private void loadResourceDefine() {
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
//        for (SysUrlModel sysUrlModel : sysUrlService.list()) {
//            Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
//            for (SysRoleModel sysRoleModel : sysUrlModel.getRoles()) {
//                ConfigAttribute ca = new SecurityConfig("ROLE_" + sysRoleModel.getId());
//                attributes.add(ca);
//            }
//            resourceMap.put(sysUrlModel.getUrl(), attributes);
//        }
    }

    // According to a URL, Find out permission configuration of this URL.
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String requestURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(requestURL);
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(requestURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
