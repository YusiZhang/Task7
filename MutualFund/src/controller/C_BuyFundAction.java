package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FundDAO;
import model.Model;
import model.TransactionDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import utils.dataConversion;
import databeans.CustomerBean;
import databeans.TransactionBean;
import formbeans.BuyFundForm;

/*
 * Processes the parameters from the form in login.jsp.
 * If successful, set the "user" session attribute to the
 * user's User bean and then redirects to view the originally
 * requested photo.  If there was no photo originally requested
 * to be viewed (as specified by the "redirect" hidden form
 * value), just redirect to manage.do to allow the user to manage
 * his photos.
 */
public class C_BuyFundAction extends Action {
	private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory
			.getInstance(BuyFundForm.class);

	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;

	public C_BuyFundAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
	}

	public String getName() {
		return "c_buyFund.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			BuyFundForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "c_buyFund.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "c_buyFund.jsp";
			}
			HttpSession session = request.getSession();
			CustomerBean customer = (CustomerBean) session
					.getAttribute("customer");
			if (!fundDAO.checkFundByTicker(form.getFundTicker())) {
				errors.add("Invalid ticker");
				return "c_buyFund.jsp";
			}

			long inputAmount = dataConversion
					.convertFromStringToThreeDigitLong(form.getAmount());
			if (inputAmount > customer.getTempcash()) {
				errors.add("Amount should not be greater than"
						+ customer.getTempcash());
				return "c_buyFund.jsp";
			}
			TransactionBean t = new TransactionBean();
			t.setAmount(inputAmount);
			t.setCustomer_id(customer.getCustomer_id());
			t.setTransaction_type("buy");
			transactionDAO.create(t);
			
			request.setAttribute("message", "new fund has been bought");
			return "c_success.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error-list.jsp";
		} catch (RollbackException e) {
			return "error-list.jsp";
		}
	}
}