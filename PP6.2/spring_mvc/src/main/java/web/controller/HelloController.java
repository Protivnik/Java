package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "cars",method = RequestMethod.GET)
    public String printCarsGet(ModelMap modelMap/*, HttpServletResponse response*/){
//        response.setCharacterEncoding("UTF-8");
        List<Car> cars;
        cars = new CarServiceImpl().getListCar();
        modelMap.addAttribute("Cars",cars);
        return "cars";
    }
    //	@RequestMapping(value = "cars", method = RequestMethod.GET)
//	public String printcarsget(HttpServletRequest request, ) throws IOException, ServletException {
//		response.setCharacterEncoding("Utf-8");
//		String locale = "en";
//		String text = "Cars";
//
//		List<Car> cars;
//		cars = new CarServiceImpl().getListCar();
//		request.setAttribute("Cars", cars);
//
//		try {
//			locale = request.getParameter("locale");
//		} catch (NullPointerException ignored) {
//
//		}
//
//		if (locale.equals("ru")) {
//			text = "МАШИНЫ";
//		}
//		request.setAttribute("loc", text);
//		return "cars";
//
//	}
//    @RequestMapping(value = "cars", method = RequestMethod.GET)
//    public String printCarsGet(@RequestParam(defaultValue = "eu") String locale, ModelMap model/*,HttpServletResponse response*/) {
////		response.setCharacterEncoding("UTF-8");
//        String text = "Cars";
//
//        List<Car> cars;
//        cars = new CarServiceImpl().getListCar();
//        model.addAttribute("Cars", cars);
//
//        if (locale.equals("ru")) {
//            text = "МАШИНЫ";
//        }
//        model.addAttribute("loc", text);
//        return "cars";
//    }
}


