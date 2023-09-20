@REGRESSION

Feature: ITunes Searh API

  Scenario Outline: Search Itunes by term
    When User search itunes with term "<term>"
    Then I verify statuscode as "200"
    Examples:
    |term|
    |jack+johnson|

  Scenario Outline: Search Itunes by term and limit
    When User search itunes with term "<term>" and limit "<limit>"
    Then I verify statuscode as "200"
    Examples:
      |term|limit|
      |jack+johnson|25|

  Scenario Outline: Search Itunes by term and entity
    When User search itunes with term "<term>" and entity "<entity>"
    Then I verify statuscode as "200"
    Examples:
      |term|entity|
      |jack+johnson|musicVideo|

  Scenario Outline: Search Itunes by term and country
    When User search itunes with term "<term>" and country "<country>"
    Then I verify statuscode as "200"
    Examples:
      |term|country|
      |jack+johnson|ca|

  Scenario Outline: Search Itunes by term, entity and country
    When User search itunes with term "<term>" entity "<entity>" and country "<country>"
    Then I verify statuscode as "200"
    Examples:
      |term|country|entity|
      |yelp|us| software  |

  Scenario Outline: Search Itunes by artist id lookup
    When User search itunes with artist ID "<artist_id>"
    Then I verify statuscode as "200"
    Examples:
      |artist_id|
      |909253|

  Scenario Outline: Search Itunes by itunes id lookup
    When User search itunes with itunes ID "<itunes_id>"
    Then I verify statuscode as "200"
    Examples:
      |itunes_id|
      |284910350|

  Scenario Outline: Search Itunes by amg id lookup
    When User search itunes with amg ID "<amg1_id>"
    Then I verify statuscode as "200"
    Examples:
      |amg1_id|
      |468749|

  Scenario Outline: Search Itunes by amg ids lookup
    When User search itunes with amg ID "<amg1_ids>"
    Then I verify statuscode as "200"
    Examples:
      |amg1_ids|
      |468749,5723|

