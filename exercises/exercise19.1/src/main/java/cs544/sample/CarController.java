package cs544.sample;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value="/cars")
public class CarController {

	@Resource
	private ICarDao carDao;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/cars";
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("cars", carDao.getAll());
		return "carList";
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.POST)
	public String add(Car car) {
		carDao.add(car);
		return "redirect:/cars";
	}

	@RequestMapping(value="/cars/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("car", carDao.get(id));
		return "carDetail";
	}
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.POST)
	public String update(Car car, @PathVariable int id) {
		carDao.update(id, car); // car.id already set by binding
		return "redirect:/cars";
	}
	
	@RequestMapping(value="/cars/delete", method=RequestMethod.POST)
	public String delete(int carId) {
		carDao.delete(carId);
		return "redirect:/cars";
	}


	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
}
