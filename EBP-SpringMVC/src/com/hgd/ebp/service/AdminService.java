package com.hgd.ebp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hgd.ebp.dao.AdminDAO;
import com.hgd.ebp.domain.Admin;
import com.hgd.ebp.exception.AdminException;
import com.hgd.ebp.exception.AdminLoginException;

@Service
@Scope("singleton")
public class AdminService {
	@Resource
    private AdminDAO adminUserDAO;
    
    public Admin adminLogin(String username, String password) 
            throws AdminLoginException, AdminException {
        List<Admin> list = adminUserDAO.queryByNamePassword(username, password);
        if (list.size() == 0) {
        	throw new AdminLoginException("�û����������");
        }
        
        if (list.size() > 1) {
        	throw new AdminLoginException("�û��ظ�������ϵ����Ա");
        }
        
        return list.get(0);
    }
}
