package org.btsoft.jf.cloud.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.config.entity.AppInfo;
import org.btsoft.jf.cloud.config.mapper.IAppInfoMapper;
import org.btsoft.jf.cloud.config.service.IAppInfoService;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService implements IAppInfoService {

    @Autowired
    private IAppInfoMapper mapper;

    @Override
    public AppInfo createSingle(AppInfo appInfo) {
    	mapper.createSingle(appInfo);
        return appInfo;
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
        AppInfo single=this.findSingle(appInfo);
        if(single!=null){
            mapper.deleteSingle(single);
        }
        return single;
    }
    
    @Override
	public void deleteMultiple(List<AppInfo> appInfos) {
    	if(appInfos!=null && !appInfos.isEmpty()){
    		mapper.deleteMultiple(appInfos);
    	}
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
