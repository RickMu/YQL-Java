# YQL-Finance-Java
<br/>
Utilizes OkHttp3 and org.json
<br/>
Able to make YQL queries and parse its response:
<br/>
Select * from yahoo.finance.quote WHERE symbol in (.....);
<br/>
Select * from yahoo.finance.historicaldata WHERE symbol in (.....) AND startDate ="YYYY-MM-DD" And endDate ="YYYY-MM-DD";
<br/>
The parsed response can be stored easily in defined data structures in Data package.
