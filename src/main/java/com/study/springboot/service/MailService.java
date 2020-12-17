package com.study.springboot.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.study.springboot.util.MailHandler;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;

	private static final String FROM_ADDRESS = "seceroom@gmail.com";

	public String sendMail(String memId, String memName, int why) {
		String subject = "";
		String text = "";
		String ran = String.valueOf(new Random().nextInt(999999));

		if (why == 0) {
			subject = "EcoFun Project - 회원가입 이메일 인증코드입니다.";
			text = new StringBuffer().append("<table style='max-width: 600px;'><tr>" + "<td><a href=\"#\"><img src=\"data:image/png;base64,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\" style=\"width:100%\"></a></td>" + "</tr><tr style=\"background-color: #4184F3; border: 1px solid #E0E0E0; text-align: center;\">" + "<td style='font-size: 24px; color: #FFFFFF; line-height: 3;'>에코펀 인증 코드</td></tr>" + "<tr style=\"background-color: #FAFAFA; border: 1px solid #F0F0F0;\"><td style=\"padding: 0 32px;\">" + "<div style=\"padding: 16px 0; text-align: center;\"><p>에코펀 회원가입을 진행하기 위한 인증 코드입니다. 하단의 인증코드를 가입 화면에 입력해주시기 바랍니다.</p>" + "<br><p><strong style='font-size: 24px; font-weight: bold;'>" + ran + "</strong></p></div><br><div>" + "<p><strong>왜 이 메일이 전송되었나요?</strong></p><p>누군가가 실수로 이메일 주소를 입력한 것일 수도 있습니다. 이 경우 이 이메일을 무시해도 됩니다.</p><p>에코펀 계정팀</p>" + "</div></td></tr><tr><td style='color: #BCBCBC; line-height: 1.5;'>이 이메일은 발신 전용입니다. 자세한 정보는" + "<a href='#' style='color: #4d90fe;' rel='noreferrer noopener' target='_blank'>에코펀 고객센터</a>에서 확인할 수 있습니다.<br></td>" + "</tr></table>").toString();
		} else if (why == 1) {
			subject = "EcoFun Project - " + memName + "님의 회원가입이 완료되었습니다.";
			text = new StringBuffer().append("<table style='max-width: 600px;'><tr>" + "<td><a href=\"#\"><img src=\"data:image/png;base64,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\" style=\"width:100%\"></a></td>" + "</tr><tr style=\"background-color: #4184F3; border: 1px solid #E0E0E0; text-align: center;\"></tr>" + "<tr style=\"background-color: #FAFAFA; border: 1px solid #F0F0F0;\"><td style=\"padding: 0 32px;\">" + "<div style=\"padding: 16px 0; text-align: center;\"><p>" + memName + "님! 에코펀의 멤버가 되신 것을 환영합니다.</p></div></td>" + "</tr><br><tr><td style='color: #BCBCBC; line-height: 1.5;'>이 이메일은 발신 전용입니다. 자세한 정보는" + "<a href='#' style='color: #4d90fe;' rel='noreferrer noopener' target='_blank'>에코펀 고객센터</a>에서 확인할 수 있습니다.<br></td>" + "</tr></table>").toString();
		} else if (why == 2) {
			subject = "EcoFun Project - 비밀번호 찾기 인증코드입니다.";
			text = new StringBuffer().append("<table style='max-width: 600px;'><tr>" + "<td><a href=\"#\"><img src=\"data:image/png;base64,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\" style=\"width:100%\"></a></td>" + "</tr><tr style=\"background-color: #4184F3; border: 1px solid #E0E0E0; text-align: center;\">" + "<td style='font-size: 24px; color: #FFFFFF; line-height: 3;'>에코펀 인증 코드</td></tr>" + "<tr style=\"background-color: #FAFAFA; border: 1px solid #F0F0F0;\"><td style=\"padding: 0 32px;\">" + "<div style=\"padding: 16px 0; text-align: center;\"><p>에코펀 계정을 다시 사용할 수 있도록 다음의 인증 코드가 발급되었습니다.</p><br>" + "<p><strong style='font-size: 24px; font-weight: bold;'>" + ran + "</strong></p></div><br><div>" + "<p><strong>왜 이 메일이 전송되었나요?</strong></p>" + "<p>자신의 에코펀 계정 정보를 기억하지 못하는 누군가가 실수로 내 이메일 주소를 입력한 것일 수도 있습니다. 이 경우 이 이메일을 무시해도 됩니다.</p>" + "<p>계정 보호를 위해 이 이메일을 전달하거나 이 코드를 다른 사람에게 제공하지 마세요.</p><p>에코펀 계정팀</p></div></td></tr><tr>" + "<td style='color: #BCBCBC; line-height: 1.5;'>이 이메일은 발신 전용입니다. 자세한 정보는" + "<a href='#' style='color: #4d90fe;' rel='noreferrer noopener' target='_blank'>에코펀 고객센터</a>에서 확인할 수 있습니다.<br></td></tr>" + "</table>").toString();
		} else if (why == 3) {
			subject = "EcoFun Project - 비밀번호가 변경되었습니다.";
			text = new StringBuffer().append("<table style='max-width: 600px;'><tr>" + "<td><a href=\"#\"><img src=\"data:image/png;base64,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\" style=\"width:100%\"></a></td>" + "</tr><tr style=\"background-color: #4184F3; border: 1px solid #E0E0E0; text-align: center;\">" + "<td style='font-size: 24px; color: #FFFFFF; line-height: 3;'>비밀번호 변경 안내</td></tr>" + "<tr style=\"background-color: #FAFAFA; border: 1px solid #F0F0F0;\"><td style=\"padding: 0 32px;\">" + "<div style=\"padding: 16px 0; text-align: center;\"><h4>" + memName + "님의 에코펀 계정 비밀번호가 변경되었습니다.</h4><br>" + "<p>직접 로그인한 것이 아니라면,</p><p>타인이 로그인하지 않도록 비밀번호를 변경하여 관리해 주세요</p><br><h5>에코펀 계정팀</h5></div></td></tr><tr>" + "<td style='color: #BCBCBC; line-height: 1.5;'>이 이메일은 발신 전용입니다. 자세한 정보는" + "<a href='#' style='color: #4d90fe;' rel='noreferrer noopener' target='_blank'>에코펀 고객센터</a>에서 확인할 수 있습니다.<br></td></tr>" + "</table>").toString();
		}

		try {
			MailHandler mailHandler = new MailHandler(mailSender);

			// 받는 사람
			mailHandler.setTo(memId);

			// 보내는 사람
			mailHandler.setFrom(MailService.FROM_ADDRESS, "에코펀 관리자");

			// 제목
			mailHandler.setSubject(subject);

			// HTML Layout
			mailHandler.setText(text, true);

			// 첨부 파일
			// mailHandler.setAttach("newTest.txt", "static/originTest.txt");

			// 이미지 삽입
			// mailHandler.setInline("sample-img", "static/sample1.jpg");
			mailHandler.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ran;
	}
}