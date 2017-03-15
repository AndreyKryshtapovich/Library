package com.epam.library.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.library.domain.dto.BookDTO;

public class Validator {
	private final static String IS_DIGITS = "\\d+";

	public static boolean addValidation(BookDTO bookDTO) {

		if (bookDTO.getAuthor() == null | bookDTO.getAuthor().isEmpty()) {
			return false;
		}

		Pattern p = Pattern.compile(IS_DIGITS);
		Matcher m = p.matcher(bookDTO.getPublishYear());

		if (!m.matches()) {
			return false;
		}

		if (bookDTO.getTitle() == null | bookDTO.getTitle().isEmpty()) {
			return false;
		}

		return true;
	}

	public static boolean getValidation(String title) {
		if (title == null | title.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean deleteValidation(String title) {
		if (title == null | title.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean renameValidation(String oldTitle, String newTitle) {
		if (oldTitle == null | oldTitle.isEmpty()) {
			return false;
		}
		if (newTitle == null | newTitle.isEmpty()) {
			return false;
		}
		return true;
	}

}
