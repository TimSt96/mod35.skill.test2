Feature: input form
#positive scenario
  Scenario: entering correct name, email, phone number
    Given url of platform 'https://skillfactory.ru/'
    Then enter name 'test'
    Then enter email 'test@test.test'
    Then enter phone '9999999999'
    And corrected
#negative scenario
  Scenario: entering incorrect name, email, phone number
    Given url of platform 'https://skillfactory.ru/'
    Then enter name '94825'
    Then enter email 'test99test?test'
    Then enter phone 'test'
    And incorrect