package next.controller.qna;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;
import next.model.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;

//import next.controller.user.CreateUserController;
//import core.mvc.Controller;
//import next.dao.UserDao;
//import next.model.User;

//public class CreateQnaController implements Controller {
public class CreateQnaController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(CreateQnaController.class);

	private QuestionDao questionDao = new QuestionDao();
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Question question = new Question(request.getParameter("writer"), request.getParameter("title"),
                request.getParameter("contents"));
        log.debug("Question : {}", question);
        questionDao.insert(question);
        return jspView("redirect:/");
	}
}
