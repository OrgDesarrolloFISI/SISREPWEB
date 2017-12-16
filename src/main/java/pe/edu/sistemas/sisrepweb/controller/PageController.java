package pe.edu.sistemas.sisrepweb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	protected final Log logger = LogFactory.getLog(PageController.class);
	
	@GetMapping("/index")
	public String index(){
		logger.info("Se ingreso a index");
		return "index";
	}
	
	@GetMapping("/layout")
	public String layout(){
		logger.info("Se ingreso a layout");
		return "fragments/layout";
	}
	
	@GetMapping("/plain-page")
	public String plainPage(){
		logger.info("Se ingreso a plain-page");
		return "plain-page";
	}
	
	@GetMapping("/form")
	public String form(){
		logger.info("Se ingreso a form");
		return "form";
	}
	
	@GetMapping("/formAdv")
	public String formAdv(){
		logger.info("Se ingreso a formAdv");
		return "formAdv";
	}
	
	@GetMapping("/tables_dynamic")
	public String tables(){
		logger.info("Se ingreso a tables_dynamic");
		return "tables_dynamic";
	}
	
	@GetMapping("/pricing-tables")
	public String pricing(){
		logger.info("Se ingreso a pricing-tables");
		return "pricing-tables";
	}
	
	
	
}

