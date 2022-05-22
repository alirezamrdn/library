package io.example.library.web.util;

public class UrlConstants {
    public static final String GLOBAL_URL = "/v1/api/library";
    public static final String GLOBAL_BORROW_URL = GLOBAL_URL + "/borrow";
    public static final String GLOBAL_BOOK_URL = GLOBAL_URL + "/book";
    public static final String BORROWER__AT_LEAST_ONE_BOOK_BORROWERS = "/atLeastOne";
    public static final String BORROWER__NON_TERMINATED_USERS_WITHOUT_BORROWING = "/nothing";
    public static final String BORROWER__FIND_BY_DATE = "/find";
    public static final String BOOK__FIND_BY_USER_DATE = "/find";
    public static final String BOOK__NOT_BORROWED = "/notBorrowed";
}
