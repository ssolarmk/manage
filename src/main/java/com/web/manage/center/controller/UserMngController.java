package com.web.manage.center.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.web.common.util.StringUtil;
import com.web.manage.center.service.UserMngService;
import com.web.manage.common.domain.PageingVO;
import com.web.manage.common.domain.ReturnDataVO;
import com.web.manage.common.domain.SessionVO;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/center/user/userMng")
public class UserMngController {

    @Autowired
    private UserMngService userMngService;

    @RequestMapping("view")
    public String view() {
        return "pages/center/userMng";
    }

    @RequestMapping("list")
    public @ResponseBody String list(@RequestBody HashMap<String, Object> hashmapParam, HttpSession session) {
       HashMap<String, Object> hashmapResult = new HashMap<String, Object>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		Gson gson = new Gson(); 
		SessionVO member = (SessionVO) session.getAttribute("S_USER");
		hashmapParam.put("user_id", member.getUserId());
		String jString = null;
        try {
            PageingVO pageing = new PageingVO();
			pageing.setPageingVO(hashmapParam);

			hashmapParam.put("srch_center", StringUtil.nullCheck((String) pageing.getSearch().get("srch_center"), "") );
			hashmapParam.put("srch_brd_tp", StringUtil.nullCheck((String) pageing.getSearch().get("srch_brd_tp"), ""));
			hashmapParam.put("srch_tp", StringUtil.nullCheck((String) pageing.getSearch().get("srch_tp"), ""));
			hashmapParam.put("srch_tp_inp", StringUtil.nullCheck((String) pageing.getSearch().get("srch_tp_inp"), ""));
			int ordCol = Integer.parseInt(String.valueOf(pageing.getOrder().get(0).get("column")));
			hashmapParam.put("sidx", pageing.getColumns().get(ordCol).get("data"));
			hashmapParam.put("sord", pageing.getOrder().get(0).get("dir"));
			
			hashmapParam.put("start", pageing.getStart());
			hashmapParam.put("end", pageing.getLength());

            list = userMngService.userMngListRetrieve(hashmapParam);
            int records =  userMngService.getQueryTotalCnt();

			 pageing.setRecords(records);
			 pageing.setTotal((int) Math.ceil((double)records / (double)pageing.getLength()));


			 hashmapResult.put("draw", pageing.getDraw());
			 hashmapResult.put("recordsTotal", pageing.getRecords());
    		 hashmapResult.put("recordsFiltered", pageing.getRecords());
			 hashmapResult.put("data", list);

             jString = gson.toJson(hashmapResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jString;
    }
    @RequestMapping(value="getAcaList", method=RequestMethod.POST)
    public @ResponseBody List<HashMap<String, Object>> getAcaList(@RequestParam HashMap<String, Object> hashmapParam) {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			list = (List<HashMap<String, Object>>) userMngService.getAcaList(hashmapParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

    }
    
	@RequestMapping("create")
	public @ResponseBody ReturnDataVO create(@RequestParam HashMap<String, Object> hashmapParam, HttpSession session) {
		ReturnDataVO result = new ReturnDataVO();
        try {
            SessionVO member = (SessionVO) session.getAttribute("S_USER");
            hashmapParam.put("ent_user_id", member.getUserId());
            if(userMngService.userCreate(hashmapParam)){
				result.setResultCode("S000");
				result.setResultMsg("사용자등록이 완료되었습니다.");
            } else {
                result.setResultCode("F000");
                result.setResultMsg("사용자등록에 실패하였습니다.");
            }
        } catch (Exception e) {
            result.setResultCode("F000");
            result.setResultMsg("등록에 실패하였습니다.");
            e.printStackTrace();
        }
        return result;
	}
	@RequestMapping("update")
	public @ResponseBody ReturnDataVO update(@RequestParam HashMap<String, Object> hashmapParam, HttpSession session) {
		ReturnDataVO result = new ReturnDataVO();
        try {
            SessionVO member = (SessionVO) session.getAttribute("S_USER");
            hashmapParam.put("ent_user_id", member.getUserId());
            if(userMngService.userUpdate(hashmapParam)){
				result.setResultCode("S000");
				result.setResultMsg("사용자등록이 완료되었습니다.");
            } else {
                result.setResultCode("F000");
                result.setResultMsg("사용자등록에 실패하였습니다.");
            }
        } catch (Exception e) {
            result.setResultCode("F000");
            result.setResultMsg("등록에 실패하였습니다.");
            e.printStackTrace();
        }
        return result;
	}
    
}
