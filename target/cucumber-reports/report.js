$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/GetStarshipInfo.feature");
formatter.feature({
  "name": "This feature verifies GET operation on starships from SW universe",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get a list of starships from SW universe",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User wants to get a list of starships",
  "keyword": "When "
});
formatter.match({
  "location": "GETRequestSteps.userWantsToGetAListOfStarships()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "GETRequestSteps.statusCodeShouldBe(int)"
});
formatter.result({
  "status": "passed"
});
});