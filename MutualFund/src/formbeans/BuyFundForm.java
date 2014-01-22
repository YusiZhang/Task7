package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class BuyFundForm extends FormBean {
	private String fundTicker;
	private String amount;

	public String getFundTicker() {
		return fundTicker;
	}

	public void setFundTicker(String fundTicker) {
		this.fundTicker = trimAndConvert(fundTicker, "<>\"");
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = trimAndConvert(amount, "<>\"");
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		if (fundTicker == null || fundTicker.length() == 0) {
			errors.add("FundTicker is required");
		}
		if (amount == null || amount.length() == 0) {
			errors.add("Amount is required");
		} else {
			int countPoint = 0;
			for (int i = 0; i < amount.length(); i++) {
				if (amount.charAt(i) == '.'
						&& (++countPoint > 1 || i < amount.length() - 3)) {
					errors.add("Invalid number");
					break;
				} else if (amount.charAt(i) < '0' || amount.charAt(i) > '9') {
					errors.add("Invalid number");
					break;
				}
			}
		}
		return errors;
	}
}