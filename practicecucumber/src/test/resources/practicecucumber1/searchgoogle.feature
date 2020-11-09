Feature: search key from google page
  Scenario: Show thes list of result suitable with keyword
    Given the google hompage is showed
    When the user attempt to search with keyword "java"
    Then List of Result is "java - Tìm với Google"showed

