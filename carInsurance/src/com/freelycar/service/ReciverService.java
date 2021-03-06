package com.freelycar.service; 

import java.util.List;
import java.util.Map;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freelycar.dao.ReciverDao;
import com.freelycar.entity.Reciver;
import com.freelycar.util.RESCODE;
import com.freelycar.util.Tools;
import org.springframework.util.StringUtils;

/**  
 *  
 */  
@Transactional
@Service
public class ReciverService  
{  
    /********** 注入ReciverDao ***********/  
    @Autowired
	private ReciverDao reciverDao;
    
    
    
    
    
    //增加一个Reciver
    public Map<String,Object> saveReciver(Reciver reciver){
		if(Tools.isEmpty(reciver.getReciver())){
			return RESCODE.PARAM_EMPTY.getJSONRES("姓名为空");
		}
		if(Tools.isEmpty(reciver.getAdressDetail())){
			return RESCODE.PARAM_EMPTY.getJSONRES("地址为空");
		}
		if(Tools.isEmpty(reciver.getExpressCompany())){
			return RESCODE.PARAM_EMPTY.getJSONRES("快递公司为空");
		}
		if(Tools.isEmpty(reciver.getOpenId())){
			return RESCODE.PARAM_EMPTY.getJSONRES("openId为空");
		}
		if(Tools.isEmpty(reciver.getExpressNumber())){
			return RESCODE.PARAM_EMPTY.getJSONRES("快递单号为空");
		}
		if(Tools.isEmpty(reciver.getPhone())){
			return RESCODE.PARAM_EMPTY.getJSONRES("手机号码为空");
		}
		if(Tools.isEmpty(reciver.getProvincesCities())){
			return RESCODE.PARAM_EMPTY.getJSONRES("省市为空");
		}
		if(reciver.getClientId()==0){
			return RESCODE.PARAM_EMPTY.getJSONRES("客户clientId为空");
		}
    	
    	
		reciverDao.saveReciver(reciver);
		return RESCODE.SUCCESS.getJSONRES();
	}
	
    // select by openid
    public Map<String,Object> getReciverByOpenId(String openId){
    	Reciver reciverByOpenId = reciverDao.getReciverByOpenId(openId);
    	if(reciverByOpenId == null){
    		return RESCODE.NOT_FOUND.getJSONRES();
    	}
    	return RESCODE.SUCCESS.getJSONRES(reciverByOpenId);
    }
	
	/**
		分页查询
	 * @param page 从第几页开始查询
	 * @param number 每页数量
	 * @return
	 */
	public Map<String,Object> listReciver(Reciver reciver, int page,int number){
	    int from = (page-1)*number;
	    List<Reciver> listPage = reciverDao.listReciver(reciver,from, number);
	    if(listPage !=null && !listPage.isEmpty()){
	    	long count = reciverDao.getReciverCount(reciver);
			return RESCODE.SUCCESS.getJSONRES(listPage,(int)Math.ceil(count/(float)number),count);
		} 
		return RESCODE.NOT_FOUND.getJSONRES();
    }
	
	
	//根据id删除Reciver
	public Map<String,Object> removeReciverById(String id){
		boolean res =  reciverDao.removeReciverById(id);
		if (res) {
			return RESCODE.SUCCESS.getJSONRES();
		} else {
			return RESCODE.DELETE_FAIL.getJSONRES();
		}
	}
	
	//更新Reciver
	public Map<String,Object> updateReciver(Reciver reciver){
	    reciverDao.updateReciver(reciver);
	    return RESCODE.SUCCESS.getJSONRES();
	}


	/**
	 * 根据orderId查询Reciver
	 * @param orderId
	 * @return
	 */
	public Reciver getReciverByOrderId(String orderId){
		if (StringUtils.isEmpty(orderId)) {
			return null;
		}
		return reciverDao.getReciverByOrderId(orderId);
	}
    
}