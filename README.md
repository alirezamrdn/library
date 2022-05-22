# library Sample App

This application provide 5 REST API that satisfies the following requirements:

1) returns all users who have actually borrowed at least one book
    * /v1/api/library/borrow/atLeastOne
2) returns all non-terminated users who have not currently borrowed anything
    * /v1/api/library/borrow/nothing
3) returns all users who have borrowed a book on a given date
    * /v1/api/library/borrow/find?fromDate=04/27/2021
4) returns all books borrowed by a given user in a given date range
    * /v1/api/library/book/find?fromDate=04/27/2021&toDate=04/29/2021&firstName=Liam&lastName=Aexi
5) returns all available (not borrowed) books
    * /v1/api/library/book/notBorrowed

****

## How to start?

Run following command in the root folder of project:

* ./mvnw spring-boot:run