package com.elm.dao;


import com.elm.po.Admin;

public interface AdminDao {

    public Admin getAdminByNameByPass(String adminName, String password);

    public int insectAdmin(Admin admin);

    public int updataAdminPassWord(Admin admin);

    public Admin selectAdminPassWord(String adminName);


}
