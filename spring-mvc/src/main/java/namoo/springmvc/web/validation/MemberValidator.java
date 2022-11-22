package namoo.springmvc.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import namoo.springmvc.web.member.dto.Member;

@Component
public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override				//Errors가 Bindinresult
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		// 폼 필드 검증
		if (!StringUtils.hasText(member.getId())) {
			errors.rejectValue("id", "required");
		} else {
			if (member.getId().length() < 6 || member.getId().length() > 12) {
				errors.rejectValue("id", "range", new Object[] { 6, 12 }, null);
			}
		}
		if (!StringUtils.hasText(member.getPasswd())) {
			errors.rejectValue("passwd", "required");
		}
		if (!StringUtils.hasText(member.getName())) {
			errors.rejectValue("name", "required");
		}
		if (member.getAge() == null || member.getAge() < 10 || member.getAge() > 100) {
			errors.rejectValue("age", "range", new Object[] { 10, 100 }, null);
		}
		// 특정 필드가 아닌 글로벌(복합) 룰 검증
		// 예) 상품 주문 시 (상품갯수 * 가격 = 10000원 이상이어야 하는 경우)
		int totalPrice = 9000;
		if (totalPrice < 10000) {
			errors.reject("totalPriceMin", new Object[] { 10000, totalPrice }, null);
		}
	}

}
