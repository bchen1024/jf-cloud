package org.btsoft.jf.cloud.app.service.impl;

import org.btsoft.jf.cloud.app.entity.AppInfo;
import org.btsoft.jf.cloud.app.mapper.IAppInfoMapper;
import org.btsoft.jf.cloud.app.service.IAppInfoService;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppInfoService implements IAppInfoService {

    @Autowired
    private IAppInfoMapper mapper;

    @Override
    public AppInfo createSingle(AppInfo appInfo) {
         int count=mapper.createSingle(appInfo);
        if(count>0){
            return this.findSingle(appInfo);
        }
        return null;
    }

    @Override
    public AppInfo findSingle(AppInfo appInfo) {
        return mapper.findSingle(appInfo);
    }

    @Override
    public AppInfo updateSingle(AppInfo appInfo) {
        mapper.updateSingle(appInfo);
        return appInfo;
    }

    @Override
    public AppInfo deleteSingle(AppInfo appInfo) {
        AppInfo app=this.findSingle(appInfo);
        if(app!=null){
            mapper.deleteSingle(app);
        }
        return app;
    }

    @Override
    public List<AppInfo> findList(AppInfo appInfo) {
        return mapper.findList(appInfo);
    }

    @Override
    public PageResult<AppInfo> findPageList(AppInfo appInfo, Page page) {
        int total=mapper.findCount(appInfo);
        List<AppInfo> result=new ArrayList<AppInfo>();
        if(total>0){
            result=mapper.findPageList(appInfo,page);
        }
        return new PageResult<AppInfo>(result,page,total);
    }

    @Override
    public AppInfo findAppByCode(AppInfo appInfo) {
        return mapper.findAppByCode(appInfo);
    }
}
