Feature: As a Customer,
  Customer want to book hotel ,
  check the given date is matching and check the result page is coming.

  Scenario Outline:
    Given Open the booking.com
    When I Search for <hotel> in search Box
    Then Show me the result <result>

    Examples:
      |hotel|result|
      |Manali|5    |
      |Goa   |5    |