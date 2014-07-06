package com.digiburo.naughty.collector.ws1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class HelloController {

  //
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   *
   * @param model
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
    logger.info("welcome welcome welcome");
		model.addAttribute("message", "Hello from HelloController.printWelcome");
		return "hello";
	}
}

