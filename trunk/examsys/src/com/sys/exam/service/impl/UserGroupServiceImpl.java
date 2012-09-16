package com.sys.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.EscapeTokenizer;
import com.sys.exam.database.Pager;
import com.sys.exam.database.bean.UserGroup;
import com.sys.exam.database.model.UgModel;
import com.sys.exam.service.ManagerService;
import com.sys.exam.service.UserGroupService;


/**
 * UserGroup generated by MyEclipse Persistence Tools
 */

public class UserGroupServiceImpl implements UserGroupService 
{

    private ManagerService managerService;

    /**
     * @return Returns the managerService.
     */
    public ManagerService getManagerService()
    {
        return managerService;
    }

    /**
     * @param managerService The managerService to set.
     */
    public void setManagerService(ManagerService managerService)
    {
        this.managerService = managerService;
    }

	@Override
	public List<UserGroup> findUgList() throws Exception {
	    List<UserGroup> listUgs=managerService.getUserGroupDao().loadAll();
		return listUgs;
	}

	@Override
	public Pager findUgPager(Pager pager) throws Exception {
		String sql="form UserGroup ug ";
		List<UserGroup> listugs=managerService.getUserGroupDao().find(sql);
		List<UgModel> listugms=new ArrayList<UgModel>();
		UgModel ugm=null;
		for (UserGroup ug : listugs)
        {
		    ugm=new UgModel();
		    ugm.setUgName(ug.getUgName());
		    ugm.setUserNum(ug.getUserGroupRels().size());
		    listugms.add(ugm);
        }
		//分页
        int pageBegin = (pager.getCurrentPage() - 1) * pager.getPageSize();
        int pageEnd = pageBegin + pager.getPageSize();
        int total = listugms.size();
        if (pageEnd > total)
            pageEnd = total;
        Pager p = new Pager(total, pager.getPageSize());
        p.setElements(listugms.subList(pageBegin, pageEnd));
        
        return p;
	}

	@Override
	public String addUg(String ugName) throws Exception {
		String ret=null;
	    
	    if (null!=ugName)
        {
            UserGroup ug=new UserGroup();
            ug.setUgName(ugName);
            managerService.getUserGroupDao().save(ug);
        }//end if
		else {
		    ret="用户名为空";
        }//end else
		return ret;
	}

	@Override
	public String deleteUgById(Long ugId) throws Exception {
		managerService.getUserGroupDao().deleteByKey(ugId);
		return null;
	}
}