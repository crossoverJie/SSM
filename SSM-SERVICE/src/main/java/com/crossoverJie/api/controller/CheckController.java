
package com.crossoverJie.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("check")
public class CheckController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping( method = { RequestMethod.GET })
	@ResponseBody
	public Object check(){
		logger.info("开始Check");
		checkJSON status = new checkJSON();
		status.setStatus("ok");
		
		return status;
		
	}
	
	public class checkJSON {
		private String status;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
