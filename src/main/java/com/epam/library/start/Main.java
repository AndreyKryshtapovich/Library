package com.epam.library.start;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.AddBookRequest;
import com.epam.library.bean.DeleteBookRequest;
import com.epam.library.bean.GetBookByTitleRequest;
import com.epam.library.bean.RenameRequest;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.CommandName;
import com.epam.library.controller.Controller;

public class Main {
	private final static Logger Logger = LogManager.getLogger(Main.class.getName());

	public static void main(String[] args) {

		Controller controller = new Controller();

		Request initRequest = new Request();
		initRequest.setCommandName(CommandName.INIT_DATA);
		Response initResponse = controller.doAction(initRequest);
		if (!initResponse.isErrorStatus()) {
			Logger.info(initResponse.getSimpleMessage());
		} else {
			Logger.info(initResponse.getErrorMessage());
		}

		AddBookRequest addRequest = new AddBookRequest();
		addRequest.setCommandName(CommandName.ADD_BOOK);
		addRequest.setAuthor("Test");
		addRequest.setBrief("Test");
		addRequest.setPublishYear(2000);
		addRequest.setTitle("Test");
		Response response = controller.doAction(addRequest);
		if (!response.isErrorStatus()) {
			Logger.info(response.getSimpleMessage());
		} else {
			Logger.info(response.getErrorMessage());
		}

		GetBookByTitleRequest getRequest = new GetBookByTitleRequest();
		getRequest.setCommandName(CommandName.GET_BOOK_BY_TITLE);
		getRequest.setTargetTitle("Mrs. Dalloway");
		Response response1 = controller.doAction(getRequest);
		if (!response1.isErrorStatus()) {
			System.out.println(response1.getBookList());
		} else {
			Logger.info(response1.getErrorMessage());
		}

		RenameRequest renameRequest = new RenameRequest();
		renameRequest.setCommandName(CommandName.RENAME);
		renameRequest.setOldTitle("Test");
		renameRequest.setNewTitle("This is Test");
		Response response2 = controller.doAction(renameRequest);
		if (!response2.isErrorStatus()) {
			Logger.info(response2.getSimpleMessage());
		} else {
			Logger.info(response2.getErrorMessage());
		}

		DeleteBookRequest deleteRequest = new DeleteBookRequest();
		deleteRequest.setCommandName(CommandName.DELETE_BOOK_BY_TITLE);
		deleteRequest.setTargetTitle("This is Test");
		Response response3 = controller.doAction(deleteRequest);
		if (!response3.isErrorStatus()) {
			Logger.info(response3.getSimpleMessage());
		} else {
			Logger.info(response3.getErrorMessage());
		}

		Request getFirstReportRequest = new Request();
		getFirstReportRequest.setCommandName(CommandName.GET_EMPL_WITH_G_THAT_ONE_BOOK);
		Response response4 = controller.doAction(getFirstReportRequest);
		if (!response4.isErrorStatus()) {
			Logger.info(response4.getReportEmplWithGThanOneBook());
		} else {
			Logger.info(response4.getErrorMessage());
		}

		Request getSecondReportRequest = new Request();
		getSecondReportRequest.setCommandName(CommandName.GET_EMPL_WITH_LQ_THAT_TWO_BOOKS);
		Response response5 = controller.doAction(getSecondReportRequest);
		if (!response5.isErrorStatus()) {
			Logger.info(response5.getReportEmplWithLQThanTwoBooks());
		} else {
			Logger.info(response5.getErrorMessage());
		}

		controller.destroyConnectionResources();

	}

}
