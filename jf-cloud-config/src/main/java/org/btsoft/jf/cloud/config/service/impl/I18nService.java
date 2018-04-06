package org.btsoft.jf.cloud.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.config.entity.I18n;
import org.btsoft.jf.cloud.config.mapper.II18nMapper;
import org.btsoft.jf.cloud.config.service.II18nService;
import org.btsoft.jf.cloud.core.entity.Page;
import org.btsoft.jf.cloud.core.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class I18nService implements II18nService {

    @Autowired
    private II18nMapper mapper;

    @Override
    public I18n createSingle(I18n I18n) {
    	mapper.createSingle(I18n);
        return I18n;
    }

    @Override
    public I18n findSingle(I18n I18n) {
        return mapper.findSingle(I18n);
    }

    @Override
    public I18n updateSingle(I18n I18n) {
        mapper.updateSingle(I18n);
        return I18n;
    }

    @Override
    public I18n deleteSingle(I18n I18n) {
        I18n single=this.findSingle(I18n);
        if(single!=null){
            mapper.deleteSingle(single);
        }
        return single;
    }
    
    @Override
	public void deleteMultiple(List<I18n> I18ns) {
    	if(I18ns!=null && !I18ns.isEmpty()){
    		mapper.deleteMultiple(I18ns);
    	}
	}

    @Override
    public List<I18n> findList(I18n I18n) {
        return mapper.findList(I18n);
    }

    @Override
    public PageResult<I18n> findPageList(I18n I18n, Page page) {
        int total=mapper.findCount(I18n);
        List<I18n> result=new ArrayList<I18n>();
        if(total>0){
            result=mapper.findPageList(I18n,page);
        }
        return new PageResult<I18n>(result,page,total);
    }

}
