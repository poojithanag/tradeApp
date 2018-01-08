Feature: Print Trade Volume

  @test
  Scenario Outline: Print list of Inst and the volume in the specified date range
    Given I have the files trades and inst
    When I specify <start_date> and <end_date>
    Then I see list of trade instruments and its volume printed in the specified date range
    Examples:
      | start_date          | end_date            |
      | 11/11/2017 23:11:01 | 17/11/2017 23:11:01 |

  @test
  Scenario Outline: Print list of Inst and the volume not in the specified date range
    Given I have the files trades and inst
    When I specify <start_date> and <end_date>
    Then I see list of trade instruments and its volume printed not in the specified date range
    Examples:
      | start_date          | end_date            |
      | 11/11/2017 23:11:01 | 17/11/2017 23:11:01 |
